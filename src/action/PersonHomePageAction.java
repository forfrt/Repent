package action;

import impl.ArticlesImpl;

import com.opensymphony.xwork2.ActionSupport;

/*
 * 针对于个人空间中药显示的部分
 * 可以写在一个方法里面
 * 1、显示这个人所发的所有帖子、文章、音乐->结合了帖子的Impl、帖子评论的Impl……
 * 2、显示这个人的所有评论，如果帖子没有被删除的话
 * 3、显示这个人的基本信息，昵称、年龄、等级、型别、头像等 
 */

public class PersonHomePageAction extends ActionSupport{
	
	private ArticlesImpl articlesImpl;
	
	
}
