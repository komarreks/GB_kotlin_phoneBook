import com.sun.jdi.Value

class PhoneBook {
    private var persons: MutableMap<String,Person> = mutableMapOf()

    fun findValues(value: String): List<String>{
        var findered = mutableListOf<String>()
        for (person in persons){
            if (person.value.havePhone(value) || person.value.haveEmail(value)){
                findered.add(person.value.getName())
            }
        }

        return findered
    }

    fun updateRecord(name: String, phone: String, email: String){
        var currentRecord = persons[name]

        if (currentRecord == null){
            currentRecord = Person(name);
        }

        if (phone.length > 0){
            currentRecord.addPhone(phone)
        }

        if (email.length > 0){
            currentRecord.addEmail(email)
        }

        persons[name] = currentRecord;
    }

    fun findRecord(name: String): Person?{
        return persons.get(name)
    }
}