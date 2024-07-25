class Help(var valide:Boolean = true) :Command {
    override fun isValid(): Boolean {
        return valide
    }

    fun printHelp(alarmMessage: String = "================================") {
        println(alarmMessage)
        println("exit - выход из программы")
        //println("add <Имя> phone <Номер телефона> - добавление контакту номера телефона") //устаревшая
        //println("add <Имя> email <Адрес электронной почты> - добавление контакту адреса электронной почты") //устаревшая
        println("addphone <Имя> <Номер телефона> - добавление контакту номера телефона")
        println("addemail <Имя> <Номер телефона> - добавление контакту адреса электронной почты")
        println("show <Имя> показать информацию по контакту")
    }
}