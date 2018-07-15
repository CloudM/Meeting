package com.service;

import java.util.List;

import com.entity.MyFile;

public interface MyFileService {
	public boolean SAddFile(MyFile mf);                 //在数据库中添加一个文件的信息
	public boolean SDeleteFile(MyFile mf);              //在数据库中删除一个文件的信息
	public boolean SChangeFile(MyFile mf);              //改变一个文件信息的UserID的值
	public MyFile SGetFile(MyFile mf);                  //从数据库中获取一个文件的全部信息后返回一个文件对象  
	public List<String> SGetFileList1(int meetingID);   //返回ResourceName列表
	public List<String> SGetFileList2(int meetingID);   //返回ResourceID列表
	public boolean SIsFileExist(MyFile mf);             //判断输入的文件对象是否存在
}
