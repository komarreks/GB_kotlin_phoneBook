package command

import model.PhoneBook

class Find(private var value: String?): Command {
    override fun isValid(): Boolean {
        return value is String
    }

    fun find(phoneBook: PhoneBook){

        var findered = listOf<String>()

        if (value != null){
            findered = phoneBook.findValues(value!!)
        }


        println(findered)
    }
}