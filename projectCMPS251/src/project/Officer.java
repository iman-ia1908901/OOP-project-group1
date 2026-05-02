package project;

/**
* @ author: Shaikha Aldosari 202303941
* @version:
* @ since : 18/4/2026
*/
public class Officer {
	/**
	*
	*/
	private int id;
	/**
	*
	*/
	private String name;
	
	/**
	 * 
	 * @param name
	 */
	public Officer(String name) {
		super();
		this.name = name;
	}
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Officer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * 
	 * @return
	 */

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 */


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return
	 */

	@Override
	public String toString() {
		return "Officer " + getName() + "- [ ID: " + getId() + " ]";

	}
	

	
	
	
	

}
