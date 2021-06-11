package com.soccer.www.vo.soccervo;

public class PlaylistVO {
	
	private int idx;
	private String name;
	private String id;
	private String pass;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	@Override
	public String toString() {
		return "PlaylistVO [idx=" + idx + ", name=" + name + ", id=" + id + ", pass=" + pass + "]";
	}
	
	
	
}
