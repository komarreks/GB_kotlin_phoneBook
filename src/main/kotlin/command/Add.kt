package command

import model.PhoneBook

open class Add(private var commandLine: String) : Command {

    override fun isValid(): Boolean {
        val lines = commandLine.split(" ")

        return when(lines[2]){
            "phone" -> checkPhone(lines[3])
            "email" -> checkEmail(lines[3])
            else -> {
                println("можно добавить только номер (phone) или почту (email), вы ввели ${lines[2]}")
                return false
            }
        }
    }

    open fun execute(phoneBook: PhoneBook){
        val lines = commandLine.split(" ")

        when(lines[2]){
            "phone" -> {
                phoneBook.updateRecord(lines[1], lines[3], "")
            }
            "email" -> {
                phoneBook.updateRecord(lines[1],"", lines[3])
            }
        }
    }

    fun checkEmail(email: String):Boolean {
        val email = email.lowercase()

        if (email.matches(Regex("[a-z\\.?]{1,}\\@[a-z\\.?]{1,}\\.[a-z]{1,4}"))){
            return true
        }else{
            println("Неверно указана электронная почта")
            return false
        }
    }

    fun checkPhone(phone: String): Boolean {
        if (phone.matches(Regex("\\+?[7|8]\\d{10}\$"))){
            return true
        }else{
            println("Номер телефона указан в неверном формате: может начинаться с плюса, далее 7 или 8 и остальные цифры номера")
            return false
        }
    }
}