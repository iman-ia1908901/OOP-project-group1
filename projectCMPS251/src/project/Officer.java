package project;

/**
* @ author: Shaikha Aldosari 202303941
* @version:1.0
* @ since : 18/4/2026
*/

/**
 * This class represents officer in the system, consisting of id and name information.
 * 
 */
/**
 * 
 */
public class Officer {
	/**
	* This is id for the officer
	*/
	private int id;
	/**
	* This is name of the officer
	*/
	private String name;
	
	/**
	 * 
	 * 
	 * Constructors
	 * @param name
	 *  creates constructor an Officer with name only.
	 */
	public Officer(String name) {
		super();
		this.name = name;
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * creates constructor an Officer with id and name
	 */
	public Officer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	/**
	 * 
	 * @return
	 * return Officer id
	 */

	public int getId() {
		return id;
	}
	


	/**
	 * @param id 
	 * sets Officer id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * 
	 * @return
	 * return Officer name
	 */


	public String getName() {
		return name;
	}


	/**
	 * @param name
	 * sets Officer name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 
	 * @return
	 * return String representation of Officer
	 */ 

	@Override
	public String toString() {
		return "Officer " + getName() + "- [ ID: " + getId() + " ]";

	}
	

	
	
	
	

}
