<%@page language="java" contentType="text/html;charset=gb2312"%>
<%@page import="com.yeepay.PaymentForOnlineService,com.yeepay.Configuration"%>
<%!	String formatString(String text){ 
			if(text == null) {
				return ""; 
			}
			return text;
		}
%>
<%
	String keyValue   = formatString(Configuration.getInstance().getValue("keyValue"));   // �̼���Կ
	String r0_Cmd 	  = formatString(request.getParameter("r0_Cmd"));										  // ҵ������
	String p1_MerId   = formatString(Configuration.getInstance().getValue("p1_MerId"));   // �̻����
	String r1_Code    = formatString(request.getParameter("r1_Code"));										// ֧�����
	String r2_TrxId   = formatString(request.getParameter("r2_TrxId"));										// �ױ�֧��������ˮ��
	String r3_Amt     = formatString(request.getParameter("r3_Amt"));											// ֧�����
	String r4_Cur     = formatString(request.getParameter("r4_Cur"));											// ���ױ���
	String r5_Pid     = formatString(request.getParameter("r5_Pid"));											// ��Ʒ����
	String r6_Order   = formatString(request.getParameter("r6_Order"));										// �̻�������
	String r7_Uid     = formatString(request.getParameter("r7_Uid"));											// �ױ�֧����ԱID
	String r8_MP      = formatString(request.getParameter("r8_MP"));											// �̻���չ��Ϣ
	String r9_BType   = formatString(request.getParameter("r9_BType"));										// ���׽����������
	String hmac       = formatString(request.getParameter("hmac"));												// ǩ������
	boolean isOK = false;
	// У�鷵�����ݰ�
	isOK = PaymentForOnlineService.verifyCallback(hmac,p1_MerId,r0_Cmd,r1_Code, 
			r2_TrxId,r3_Amt,r4_Cur,r5_Pid,r6_Order,r7_Uid,r8_MP,r9_BType,keyValue);
	if(isOK) {
		if(r1_Code.equals("1")) {
			// ��Ʒͨ�ýӿ�֧���ɹ�����-������ض���
			/*
			
			*�ı䶩���ĺ�
			    
			
			
			*
			*/
			
			
			
			
			
			if(r9_BType.equals("1")) {
				
				out.println("callback��ʽ:��Ʒͨ�ýӿ�֧���ɹ�����-������ض���");
				//�ɹ���תҳ��
				// ��Ʒͨ�ýӿ�֧���ɹ�����-��������Ե�ͨѶ
			} else if(r9_BType.equals("2")) {
				// ����ڷ���������ʱ	����ʹ��Ӧ�����ʱ������Ӧ����"success"��ͷ���ַ�������Сд������
				out.println("SUCCESS");
			  // ��Ʒͨ�ýӿ�֧���ɹ�����-�绰֧������		
			} else if(r9_BType.equals("3")) {
				
			}
			// ����ҳ������ǲ���ʱ�۲���ʹ��
			out.println("<br>���׳ɹ�!<br>�̼Ҷ�����:" + r6_Order + "<br>֧�����:" + r3_Amt + "<br>�ױ�֧��������ˮ��:" + r2_TrxId);
		}
	} else {
		out.println("����ǩ�����۸�!");
	}
	
%>