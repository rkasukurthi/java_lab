package geb

Browser.drive {
	go "http://myapp.com/login"
	 
	assert $("h1").text() == "Please Login"
	 
	$("form.login").with {
		username = "admin"
		password = "password"
		login().click()
	}
	 
	assert $("h1").text() == "Admin Section"
}