
package com.example.mycity

object DataSource {

    val places = listOf(

        // РЕСТОРАНЫ

        Place(
            id = 1,
            name = "PORT42",
            description = "Ресторан с красивым видом на реку Томь. Европейская кухня, завтраки и авторские блюда.",
            category = "Рестораны",
            imageRes = R.drawable.port42,
            address = "Притомская набережная, 7"
        ),

        Place(
            id = 2,
            name = "Забой",
            description = "Ресторан в шахтёрском стиле с необычной атмосферой и разнообразным меню.",
            category = "Рестораны",
            imageRes = R.drawable.zaboy,
            address = "Бульвар Строителей, 21"
        ),

        Place(
            id = 3,
            name = "Мюнхен",
            description = "Ресторан с баварской атмосферой и разнообразным меню.",
            category = "Рестораны",
            imageRes = R.drawable.munhen,
            address = "Ленинградский проспект, 28/1"
        ),

        Place(
            id = 4,
            name = "Волна",
            description = "Ресторан в центральной части города для встреч и отдыха.",
            category = "Рестораны",
            imageRes = R.drawable.volna,
            address = "Улица Томская, 5"
        ),

        Place(
            id = 5,
            name = "Шашлыкoff",
            description = "Гриль-бар с мясными блюдами и уютной атмосферой.",
            category = "Рестораны",
            imageRes = R.drawable.shashlykoff,
            address = "Советский проспект, 28А"
        ),

        Place(
            id = 6,
            name = "Чайхана 42",
            description = "Заведение с восточной кухней, ароматными блюдами и уютной атмосферой.",
            category = "Рестораны",
            imageRes = R.drawable.chaihana_42,
            address = "Кемерово"
        ),

        // ПАРКИ

        Place(
            id = 7,
            name = "Парк Чудес",
            description = "Известный парк Кемерова с аттракционами, прогулочными дорожками и развлечениями.",
            category = "Парки",
            imageRes = R.drawable.park_chudes,
            address = "Улица Кузбасская, 4"
        ),

        Place(
            id = 8,
            name = "Парк Антошка",
            description = "Семейное место отдыха с зелёными зонами и развлечениями для детей.",
            category = "Парки",
            imageRes = R.drawable.park_antoshka,
            address = "Улица Мичурина, 26"
        ),

        Place(
            id = 9,
            name = "Комсомольский парк",
            description = "Зелёная территория для прогулок, занятий спортом и отдыха на свежем воздухе.",
            category = "Парки",
            imageRes = R.drawable.komsomolsky_park,
            address = "Кемерово"
        ),

        Place(
            id = 10,
            name = "Парк Победы имени Жукова",
            description = "Памятное место с аллеями, мемориальными объектами и прогулочными зонами.",
            category = "Парки",
            imageRes = R.drawable.park_zhukova,
            address = "Район Советского проспекта и улицы Мичурина"
        ),

        Place(
            id = 11,
            name = "Рудничный сосновый бор",
            description = "Большой сосновый лес внутри города. Отличное место для прогулок и отдыха на природе.",
            category = "Парки",
            imageRes = R.drawable.sosnovy_bor,
            address = "Улица Волкова"
        ),

        Place(
            id = 12,
            name = "Парк Ангелов",
            description = "Мемориальное пространство с благоустроенной территорией и местами для отдыха.",
            category = "Парки",
            imageRes = R.drawable.park_angelov,
            address = "Проспект Ленина"
        ),

        Place(
            id = 13,
            name = "Бульвар Строителей",
            description = "Прогулочная территория с зеленью, дорожками и местами для отдыха.",
            category = "Парки",
            imageRes = R.drawable.bulvar_stroiteley,
            address = "Бульвар Строителей"
        ),

        // КОФЕЙНИ

        Place(
            id = 14,
            name = "Coffee Like",
            description = "Кофейня с напитками на основе эспрессо и кофе с собой.",
            category = "Кофейни",
            imageRes = R.drawable.coffee_like,
            address = "Бульвар Строителей, 29/2"
        ),

        Place(
            id = 15,
            name = "Port Coffee",
            description = "Кофейное место в центре города для быстрого перерыва.",
            category = "Кофейни",
            imageRes = R.drawable.port_coffee,
            address = "Весенняя улица, 13"
        ),

        Place(
            id = 25,
            name = "Малевич",
            description = "Уютная кофейня, где можно насладиться ароматным кофе, провести время с друзьями и отдохнуть.",
            category = "Кофейни",
            imageRes = R.drawable.malevich,
            address = "Кемерово"
        ),

        // КИНОТЕАТРЫ

        Place(
            id = 16,
            name = "Гринвич",
            description = "Кинотеатр для просмотра новинок и популярных фильмов.",
            category = "Кинотеатры",
            imageRes = R.drawable.greenwich,
            address = "Молодёжный проспект, 2"
        ),

        Place(
            id = 17,
            name = "Рио Синема",
            description = "Кинотеатр с разнообразной программой фильмов.",
            category = "Кинотеатры",
            imageRes = R.drawable.rio_cinema,
            address = "Проспект Шахтёров, 89"
        ),

        Place(
            id = 18,
            name = "Юбилейный",
            description = "Городской кинотеатр с разнообразной программой показов.",
            category = "Кинотеатры",
            imageRes = R.drawable.yubileyny,
            address = "Проспект Ленина, 91"
        ),

        Place(
            id = 19,
            name = "Кузбасскино",
            description = "Кинозал для любителей кино и культурных мероприятий.",
            category = "Кинотеатры",
            imageRes = R.drawable.kuzbasskino,
            address = "Советский проспект, 4"
        ),

        // ТОРГОВЫЕ ЦЕНТРЫ

        Place(
            id = 20,
            name = "Лапландия",
            description = "Крупный торговый центр с магазинами, развлечениями и местами для отдыха.",
            category = "Торговые центры",
            imageRes = R.drawable.laplandia,
            address = "Октябрьский проспект, 34"
        ),

        Place(
            id = 21,
            name = "Променад-1",
            description = "Торгово-развлекательный комплекс с магазинами и местами для отдыха.",
            category = "Торговые центры",
            imageRes = R.drawable.promenad_1,
            address = "Проспект Ленина, 90/1"
        ),

        Place(
            id = 22,
            name = "Променад-3",
            description = "Торговый центр с магазинами, кинотеатром и развлечениями.",
            category = "Торговые центры",
            imageRes = R.drawable.promenad_3,
            address = "Проспект Ленина, 59А"
        ),

        Place(
            id = 23,
            name = "Радуга",
            description = "Торговый центр с магазинами и различными услугами.",
            category = "Торговые центры",
            imageRes = R.drawable.raduga,
            address = "Проспект Шахтёров, 54"
        ),

        Place(
            id = 24,
            name = "Летосити",
            description = "Современный торговый центр с магазинами и местами для отдыха.",
            category = "Торговые центры",
            imageRes = R.drawable.letocity,
            address = "Московский проспект, 19"
        )
    )
}
