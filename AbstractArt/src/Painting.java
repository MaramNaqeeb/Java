
public class Painting extends Art {
	
private String paintype;

public String getPaintype() {
	return paintype;
}

public void setPaintype(String paintype) {
	this.paintype = paintype;
}

public Painting(String title, String author, String description, String paintype) {
	super(title, author, description);
	this.paintype = paintype;
}

@Override
public void viewArt() {
	// TODO Auto-generated method stub

System.out.println(getTitle()+" "+ getAuthor()+" "+getDescription()+" "+this.getPaintype());


}




}
