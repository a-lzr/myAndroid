package by.tms.myandroid.lesson5

class Lesson5ProductCollection {
    val collection = ArrayList<Lesson5Product>()
    var position = 0

    companion object {
        val instance by lazy { Lesson5ProductCollection() }
    }

    fun initCollection() {
        for (i in 1..10) {
            collection.add(
                Lesson5Product(
                    "https://grandkulinar.ru/uploads/posts/2014-04/1398269910_pomidor-tomat.jpg",
                    "Tomato",
                    1.5
                )
            )
            collection.add(
                Lesson5Product(
                    "https://e3.edimdoma.ru/data/ingredients/0000/1032/1032-ed4_wide.jpg",
                    "Potato",
                    0.5
                )
            )
            collection.add(
                Lesson5Product(
                    "https://st2.depositphotos.com/1006602/12439/i/950/depositphotos_124390654-stock-photo-cucumber-it-is-isolated-on.jpg",
                    "Cucumber",
                    2.0
                )
            )
            collection.add(
                Lesson5Product(
                    "https://fermoved.ru/wp-content/uploads/2018/07/kalorijnost-sostav-bzhu-cennost-600x450.jpg",
                    "Carrot",
                    0.8
                )
            )
            collection.add(
                Lesson5Product(
                    "https://agronomu.com/media/res/2/9/2/2/0/29220.opzgu0.300.jpg",
                    "Beet",
                    0.6
                )
            )
        }
    }
}