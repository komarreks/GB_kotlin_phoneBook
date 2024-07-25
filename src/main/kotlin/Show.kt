class Show(private var name: String?):Command {
    override fun isValid(): Boolean {
        return true
    }

    fun show(phoneBook: PhoneBook){
        if (name == null) return
        var person = phoneBook.findRecord(name!!)

        if (person != null){
            println("Контакт: ${person.getName()} \n" +
                    "========Список телефонов===========\n" +
                    person.getPhones() + "\n" +
                    "========Список email===============\n" +
                    person.getEmails())
        }else{
            println("Контакт не найден")
        }
    }
}