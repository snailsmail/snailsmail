package cn.springmvc.dao;

import cn.springmvc.model.Board;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by chenye on 16-3-4.
 */
public interface BoardDAO {

    /**
     * 获得所有对象
     *
     */
    public List<Board> getAllBoard();

    /**
     * 通过用户boardno获得对象
     * @param boardno
     * @return
     */
    public Board getBoard(@Param("boardno") String boardno);

    /**
     * 添加新对象
     * @param
     * @return
     */
    public void insertBoard(@Param("boardno") String boardno, @Param("bname") String bname, @Param("state") boolean state);

    /**
     * 通过boardno删除
     * @param boardno
     * @return
     */
    public void deleteBoard(@Param("boardno") String boardno);


    /**
     * 更新对象
     * @param
     * @return
     */
    public void updateBoard(@Param("bname") String bname, @Param("state") boolean state, @Param("boardno") String boardno);


}
