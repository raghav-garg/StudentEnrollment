/**
 * This is the function which validates the details of the user at the client side
 * @returns {Boolean} true when details are validated at the client level
 */

function validateAddForm()
{
	var firstName = document.forms["add"]["student.firstName"].value;
	var lastName = document.forms["add"]["student.lastName"].value;
	var zipCode = document.forms["add"]["student.residentAddress.zipCode"].value;
	var houseNumber = document.forms["add"]["student.residentAddress.houseNumber"].value;
	var city = document.forms["add"]["student.residentAddress.city"].value;
	var street = document.forms["add"]["student.residentAddress.street"].value;
	var state = document.forms["add"]["student.residentAddress.state"].value;
	var country = document.forms["add"]["student.residentAddress.country"].value;
	var courseList = document.forms["add"]["courseID"].value;
	var dateOfBirth = document.forms["add"]["student.dateOfBirth"].value;
	
	if(courseList==null ||courseList.length==0) {
		alert("Please Select an appropriate Course");
  		return false;
	}
	if ( firstName==null ||  firstName=="")
	{
  		alert("Enter Your First Name");
  		return false;
	}
	
	if ( lastName==null ||  lastName=="")
	{
  		alert("Enter Your Middle Name");
  		return false;
	}
	
	if ( dateOfBirth==null ||  dateOfBirth=="")
	{
  		alert("Enter Your Date of Birth");
  		return false;
	}
	
	if ( houseNumber==null ||  houseNumber=="")
	{
  		alert("Enter Your HouseNumber");
  		return false;
	}
	
	if ( street==null ||  street=="")
	{
  		alert("Enter Your Street");
  		return false;
	}
	
	if ( zipCode==null ||  zipCode=="")
	{
  		alert("Enter Your Zip Code");
  		return false;
	}
	
	if ( city==null ||  city=="")
	{
  		alert("Enter Your City");
  		return false;
	}
	
	if ( state==null ||  state=="")
	{
  		alert("Enter Your  State");
  		return false;
	}
	
	if ( country==null ||  country=="")
	{
  		alert("Enter Your Country");
  		return false;
	}
}

/**
 * This function validates the Login form input details at the user level
 * @returns {Boolean} : true when the login details are validated
 */
function validateLoginForm()
{
	var name = document.forms["loginForm"]["username"].value;
	var password = document.forms["loginForm"]["password"].value;
	if (name==null || name=="")
	{
		alert("You have not entered user name");
		return false;
	}
  
	if (password==null || password=="")
	{
		alert("You have not entered password");
		return false;
	}
}

/**
 * This function validates the marks form. The marks entered are correct or not
 * @returns {Boolean} : true when the input are validated else false
 */
function validateMarksForm()
{        
       var z=document.getElementsByName("marks");
       for (var x = 0; x < z.length; x++) {
         if(z[x].value=="" || z[x].value<0 ||z[x].value>100 ) {
        	 alert("Enter valid marks");
     		return false;
         } 
       }    
  return true;
}