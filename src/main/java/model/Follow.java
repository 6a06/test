package model;

public class Follow {
	private int follow;
	private int follower;
	public Follow() {}
	public Follow(int follow, int follower) {
		super();
		this.follow = follow;
		this.follower = follower;
	}
	public int getFollow() {
		return follow;
	}
	public void setFollow(int follow) {
		this.follow = follow;
	}
	public int getFollower() {
		return follower;
	}
	public void setFollower(int follower) {
		this.follower = follower;
	}
}
