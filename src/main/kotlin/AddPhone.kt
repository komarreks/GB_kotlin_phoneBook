class AddPhone(private var commandLine: String): Add(commandLine) {
    override fun isValid(): Boolean {
        val lines = commandLine.split(" ")

        return checkPhone(lines[2])
    }

    override fun execute(phoneBook: PhoneBook) {
        val lines = commandLine.split(" ")

        phoneBook.updateRecord(lines[1],lines[2],"")
    }
}