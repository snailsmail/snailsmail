+function ($) {
  'use strict';

  function isFunction(fn) {
    return Object.prototype.toString.call(fn)=== '[object Function]';
  }

  var MajorSelect = function (element, options) {

    this.options = options;

    this.$div = $(element);

    this.initEmptyOption(this.options.education);
    this.initEmptyOption(this.options.department);
    this.initEmptyOption(this.options.major);
    this.initEmptyOption(this.options.majorDirection);

    this.initSelectOptions();

    this.notifyMajorChange();

    this.notifyDirectionChange();
  }

  MajorSelect.VERSION = '0.0.1';

  MajorSelect.prototype.initEmptyOption = function (option) {
    option.$ele.on('change', function() {
      if($(this).val() == 0) {
        $(this).val('');
      }
    });
  }

  MajorSelect.prototype.initSelectOptions = function () {

    //初始化education的options
    this.initEducationOptions(this.options.education);

    //初始化department的options
    this.initDepartmentOptions(this.options.department);

    if (!this.options.major.initValue) {
      this.generateOptions(this.options.major, []);
    } else {
      this.fetchOptions(this.options.major, this.options.department.initValue,
                        this.options.education.initValue, null);
    }

    if (!this.options.majorDirection.initValue) {
      this.generateOptions(this.options.majorDirection, []);
    } else {
      this.fetchOptions(this.options.majorDirection, this.options.department.initValue,
                  this.options.education.initValue, this.options.majorDirection.initValue);
    }

  }

  MajorSelect.prototype.initEducationOptions = function(option) {

    this.options.education = $.extend({}, this.options.education, option);

    var self = this;

    if (isFunction(this.options.education.fetchData)) {
      self.generateOptions(self.options.education, this.options.education.fetchData());
    } else {

      var fetchData = this.fetchUrl(this.options.education);

      var url = fetchData.replace("bizTypeId={}", "bizTypeId=" + this.options.bizTypeId);

      $.ajax({
        type: 'GET',
        url: (self.options.contextPath) ? (self.options.contextPath + url) : url,
        success: function (response) {
          self.generateOptions(self.options.education, response);
        }
      });
    }
  }

  MajorSelect.prototype.initDepartmentOptions = function(option) {
    this.options.department = $.extend({}, this.options.department, option);

    var self = this;

    if (isFunction(this.options.department.fetchData)) {
      self.generateOptions(self.options.department, this.options.department.fetchData());
    } else {

      var fetchData = this.fetchUrl(this.options.department);

      var url = fetchData.replace("bizTypeId={}", "bizTypeId=" + this.options.bizTypeId);

      $.ajax({
        type: 'GET',
        url: (self.options.contextPath) ? (self.options.contextPath + url) : url,
        success: function (response) {
          self.generateOptions(self.options.department, response);
        }
      });
    }
  }

  MajorSelect.prototype.generateOptions = function(options, optionValues) {
    var selectizeOptions = [{id:0, nameZh:'...', nameEn: '...'}];
    var items = [];

    $.each(optionValues, function() {
      selectizeOptions.push({id: this.id, nameZh: this.nameZh, nameEn: this.nameEn});
    });

    if (options.initValue) {
      items.push(options.initValue);
    } else {
      items.push(0);
    }

    var $selectize = options.$ele.selectize({
      persist: false,
      allowEmptyOption: true,
      valueField: 'id',
      labelField: window.LOCALE == 'zh' ? 'nameZh' : 'nameEn',
      searchField: window.LOCALE == 'zh' ? 'nameZh' : 'nameEn',
      options: selectizeOptions,
      items: items,
      render: {
        item: function(data, escape) {
          return '<div>' + escape(window.LOCALE == 'zh' ? data.nameZh : data.nameEn) + '</div>';
        }
      }
    });

    if(options.$ele.val() == 0) {
      options.$ele.val('');
    }
    return $selectize[0].selectize;
  }

  MajorSelect.prototype.fetchUrl = function(option) {

    var fetchData = option.fetchData;

    /**
     * 若prefix不为空则用prefix为前缀的url,
     * 若为空:
     * 1.hasDataPermission为false, url为/major-select/data（不考虑数据权限）,
     * 2.hasDataPermission为true, url为/major-select/perm-data（考虑数据权限）
     */
    if (this.options.prefix) {
      fetchData = self.options.prefix + fetchData;
    } else {
      if (!option.hasDataPermission) {
        fetchData = '/major-select/data' + fetchData;
      } else {
        fetchData = '/major-select/perm-data' + fetchData;
      }
    }

    return fetchData;
  }

  /**
   * 发ajax请求, 根据条件得到新的Options
   */
  MajorSelect.prototype.fetchOptions = function(option, departmentId, educationId, majorId) {
    var self = this;

    var fetchData = this.fetchUrl(option);
    var initUrl = fetchData.replace("bizTypeId={}", "bizTypeId="+this.options.bizTypeId)
        .replace("ignoreOpenInfoEnableStatus={}", "ignoreOpenInfoEnableStatus=" + self.options.ignoreOpenInfoEnableStatus);

    var url_depart = "";
    if (departmentId && departmentId != 0) {
      url_depart = initUrl.replace("departmentId={}", "departmentId=" + departmentId);
    }else {
      url_depart = initUrl.replace("&departmentId={}", "");
    }

    var url_education = "";
    if (educationId && educationId != 0) {
      url_education = url_depart.replace("educationId={}", "educationId=" + educationId);
    } else {
      url_education = url_depart.replace("&educationId={}", "");
    }

    var url = "";
    if (option == this.options.major) {
      url = url_education;
    } else if (option == this.options.majorDirection) {
      url = url_education.replace("majorId={}", "majorId=" + majorId);;
    }
    $.ajax({
      type: 'GET',
      url: (self.options.contextPath) ? (self.options.contextPath + url) : url,
      success: function (response) {
        var control = self.clearOptions(option);
        control.addOption(response);
        control.addItem(option.initValue);
      }
    });
  }

  MajorSelect.prototype.notifyMajorChange = function() {

    var self = this;

    //部门更改事件
    this.options.department.$ele.on('change', function() {
      if (!$(this).val() || $(this).val() == 0) {
        self.clearOptions(self.options.major);
        return;
      }

      self.fetchOptions(self.options.major, $(this).val(), self.options.education.$ele.val(), null);

    });

    //学历层次更改事件
    this.options.education.$ele.on('change', function() {
      if (!self.options.department.$ele.val() || self.options.department.$ele.val() == 0) {
        return;
      }

      self.fetchOptions(self.options.major, self.options.department.$ele.val(), $(this).val(), null);

    });
  }

  MajorSelect.prototype.clearOptions = function(option) {
    //this.options.major = $.extend({}, this.options.major, option);

    var control = this.generateOptions(option, []);
    control.clearOptions();
    control.addOption({id:0, nameZh:'...', nameEn:'...'});
    control.addItem(0);

    return control;
  }

  MajorSelect.prototype.notifyDirectionChange = function() {

    var self = this;

    this.options.major.$ele.on('change', function() {
      if (!$(this).val() || $(this).val()==0) {
        self.clearOptions(self.options.majorDirection);
        return;
      }

      var departmentId = null;
      if (self.options.department.$ele.val()) {
        departmentId = self.options.department.$ele.val();
      } else {
        departmentId = self.options.department.initValue;
      }

      var educationId = null;
      if (self.options.education.$ele.val()) {
        educationId = self.options.education.$ele.val();
      } else {
        educationId = self.options.education.initValue;
      }
      self.fetchOptions(self.options.majorDirection, departmentId,
          educationId, $(this).val());

    });
  }


  // MajorSelect PLUGIN DEFINITION
  // =======================

  function Plugin(option) {
    var args = arguments;
    var ret;
    this.each(function () {
      var $this = $(this);
      var data = $this.data('majorSelect');

      if (!data) {
        var options = $.extend(true, {}, $.fn.majorSelect.defaults, typeof option == 'object' && option);
        $this.data('majorSelect', (data = new MajorSelect(this, options)))
      }

      if (typeof option == 'string') {
        if (args.length == 1) {
          var _ret = data[option].call(data);
          if (typeof _ret != 'undefined') {
            ret = _ret;
          }
        } else {
          var _ret = data[option].apply(data, Array.prototype.slice.call(args, 1));
          if (typeof _ret != 'undefined') {
            ret = _ret;
          }
        }
      }
    })

    if (typeof ret != 'undefined') {
      return ret;
    }
    return this;

  }

  var old = $.fn.majorSelect

  $.fn.majorSelect = Plugin
  $.fn.majorSelect.Constructor = MajorSelect
  $.fn.majorSelect.defaults = {

    contextPath: window.CONTEXT_PATH || '',

    bizTypeId : 0,

    /**所用controller的类级别的路径，方法级别上的路径在下面的fetchData中定义, 若prefix传了值, 则不考虑hasDataPermission*/
    prefix: '',

    education: {
      enabled: true,

      /**是否考虑数据权限:
       * 若为true, prefix为'/major-select/perm-data',
       * 若为false, prefix为'/major-select/data'
       */
      hasDataPermission : true,
      $ele: null,
      fetchData: '/educations?bizTypeId={}' || function() {
        return [{
          id: 0,
          code: '',
          nameZh: '',
          nameEn: ''
        }]
      },
      initValue: null
    },
    department: {
      enabled: true,
      hasDataPermission : true,
      $ele: null,
      fetchData: '/departments?bizTypeId={}' || function() {
        return [{
          id: 0,
          code: '',
          nameZh: '',
          nameEn: ''
        }]
      },
      initValue: null
    },
    major: {
      enabled: true,
      hasDataPermission : true,
      $ele: null,
      fetchData: '/majors?bizTypeId={}&educationId={}&departmentId={}&ignoreOpenInfoEnableStatus={}' || function() {
        return [{
          id: 0,
          code: '',
          nameZh: '',
          nameEn: ''
        }]
      },
      initValue: null
    },
    majorDirection: {
      enabled: true,
      hasDataPermission : true,
      $ele: null,
      fetchData: '/major-directions?bizTypeId={}&educationId={}&departmentId={}&majorId={}&ignoreOpenInfoEnableStatus={}' || function() {
        return [{
          id: 0,
          code: '',
          nameZh: '',
          nameEn: ''
        }]
      },
      initValue: null
    },
    ignoreOpenInfoEnableStatus: false

  };

  // MajorSelect NO CONFLICT
  // =================
  $.fn.majorSelect.noConflict = function () {

    $.fn.majorSelect = old;
    return this;

  }

}(jQuery);
