package Models

class User {
    var firstname = ""
    var lastname = ""
    var email = ""
    var mobile: Long = 0  // Declare as Long
    var password = ""
    var confirmpassword = ""

    constructor()

    constructor(
        firstname: String,
        lastname: String,
        email: String,
        mobile: Long,  // Declare as Long
        password: String,
        confirmpassword: String
    ) {
        this.firstname = firstname
        this.lastname = lastname
        this.email = email
        this.mobile = mobile
        this.password = password
        this.confirmpassword = confirmpassword
    }
}
