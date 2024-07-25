fun main(args: Array<String>) {
    val phoneBook = createPhoneBook()
    while (true){
        print("Введите команду: ")

        var command = readCommand(readlnOrNull())

        println(command)

        if (command.isValid()){
            when(command){
                is Exit -> break
                is Help -> command.printHelp()
                is Add -> command.execute(phoneBook)
                is Show -> command.show(phoneBook)
                is AddPhone -> command.execute(phoneBook)
                is AddEmail -> command.execute(phoneBook)
                is Find -> command.find(phoneBook)
                }
        }else
            Help(false).printHelp("Команда не распознана")
    }
}

fun readCommand(commandLine: String?):Command{
    val command = commandLine?.split(" ")?.get(0)?.lowercase()
    return when(command){
        "exit" -> Exit()
        "help" -> Help()
        //"add" -> Add(commandLine) //устаревшая
        "show" -> Show(commandLine?.split(" ")?.get(1))
        "addphone" -> AddPhone(commandLine)
        "addemail" -> AddEmail(commandLine)
        "find" -> Find(commandLine?.split(" ")?.get(1))
        else -> Help(false)
    }
}

fun createPhoneBook(): PhoneBook{
    return PhoneBook();
}