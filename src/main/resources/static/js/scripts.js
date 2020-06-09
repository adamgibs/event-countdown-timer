//contains all of the code for getting and using user data
function User(){
	this.getUsers = function(){
		return fetch('http://localhost:8080/users')
		.then(function (response) {
			if (response.ok) {
				return response.json();
			}
			return Promise.reject(response);
		}).catch(function (error) {
			console.warn('Something went wrong.', error);
		});
	};
	
	this.doesUserExist = function(username){
		let users = this.getUsers().then(result => result._embedded.users);
		let result = false;
		users.forEach(user => {
			if (user.username == username) result = true;
			}
		)
		return result;
	}
	
	this.loginUser = function(){
		if(this.doesUserExist){
			window.location.replace("http://localhost:8080/index");
		}
	}
}


let loginForm = "<form id='loginForm'>" +
    "<label for='username'>Username:</label><br>" +
    "<input type='text' id='username' name='username'><br>" +
    "<label for='password'>Password:</label><br>" +
    "<input type='text' id='password' name='Password'><br>" +
    "<input type='submit' id='submit' name='submit'><br>" +
  "</form>";

let registrationForm =  "<form id='registrationForm'>" +
    "<label for='username'>Username:</label><br>" +
    "<input type='text' id='username' name='username'><br>" +
    "<label for='password'>Password:</label><br>" +
    "<input type='text' id='password' name='Password'><br>" +
    "<label for='password'> Re-enter Password:</label><br>" +
    "<input type='text' id='reenter_password' name='Reenter Password'><br>" +
    "<input type='submit' id='submit' name='submit'><br>" +
  "</form>"; 

let currentForm = "login",
    loginButton = document.getElementById("loginButton"),
    registerButton = document.getElementById("registerButton"),
    formDiv = document.getElementById("formDiv"),
    displayErrors = document.getElementById("displayErrors");
    

loginButton.addEventListener("click", function(){
  currentForm = "login";
  changeForm();
});

registerButton.addEventListener("click", function(){
  currentForm = "register";
  changeForm();
});


//helper functions........
function changeForm(){
  if(currentForm == "login"){
    formDiv.innerHTML= loginForm;
    displayErrors.innerHTML = "";
    loginSubmit();
  }else {
    formDiv.innerHTML = registrationForm;
    displayErrors.innerHTML = "";
    registerSubmit();
  }
  
}

function loginSubmit(){
  let username = document.getElementById("username"),
      password = document.getElementById("password"),
      loginFormId = document.getElementById("loginForm");

  
      loginFormId.addEventListener("submit", function(event){
        event.preventDefault();
        if(username.value.trim().length == 0 || password.value.trim().length == 0  ){
            displayErrors.innerHTML = "Invalid input!!!";
            return;
          }
        let user = new User();
        user.loginUser();
      });

}

function registerSubmit(){
  let username = document.getElementById("username"),
      password = document.getElementById("password"),
      reenterPassword = document.getElementById("reenter_password"),
      registrationFormId = document.getElementById("registrationForm");
  

  registrationFormId.addEventListener("submit", function(event){
    event.preventDefault();
    if(username.value.trim().length == 0 || password.value.trim().length == 0 || reenterPassword.value.trim().length == 0  ){
        displayErrors.innerHTML = "No blank fields!!!";
        return;
      }
    if(password.value.trim() != reenterPassword.value.trim()  ){
        displayErrors.innerHTML = "Your passwords don't match!!!";
        return;
      }
    
  });
}



