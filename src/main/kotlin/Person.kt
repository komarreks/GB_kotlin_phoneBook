import java.lang.StringBuilder

data class Person(private val name: String){

    private var phones: MutableSet<String> = mutableSetOf()
    private var emails: MutableSet<String> = mutableSetOf()

    fun getName(): String{
        return name
    }

    fun getPhones():String{
        var sb = StringBuilder()

        for (phone in phones){
            sb.append(phone + "\n")
        }

        return sb.toString()
    }

    fun getEmails():String{
        var sb = StringBuilder()

        for (email in emails){
            sb.append(email + "\n")
        }

        return sb.toString()
    }

    fun addPhone(phone: String){
        phones.add(phone)
    }

    fun addEmail(email: String){
        emails.add(email)
    }

    fun havePhone(phone: String): Boolean{
        return phones.filter { it == phone }.count() > 0
    }

    fun haveEmail(email: String): Boolean{
        return emails.filter { it == email }.count() > 0
    }

}