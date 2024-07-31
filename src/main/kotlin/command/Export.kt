package command

import dsl.jsonArr
import model.PhoneBook
import java.io.File

class Export(private val path: String): Command {
    override fun isValid(): Boolean {
        return true
    }

    fun save(phoneBook: PhoneBook){

        var textToSave = ""

        val persons = phoneBook.getMapAsList()

        textToSave = jsonArr {
            persons.forEach {
                jsObject {
                    field("name", it.getName())
                    field("phones", it.getPhonesAsList())
                    field("emails", it.getEmailsAsList())
                }
            }
        }

        File(path).writeText(textToSave)
    }
}