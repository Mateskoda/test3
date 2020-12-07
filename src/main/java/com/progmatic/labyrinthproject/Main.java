package com.progmatic.labyrinthproject;

public class Main {
//    Feladatok
//    Fork-old (howto) saját felhasználódhoz a https://github.com/pappgergely/progmatic-labyrinth.git repository-ban található projektet, majd nyisd meg az általad használt fejlesztői eszközben (Intellij IDEA, NetBeans...stb) !
//    A projekt megnyitása után a projekt mappáján kattints jobb gombbal, majd válaszd ki fejlesztőeszköztől függően a “Clean and build” vagy “Rebuild...” opciót. (Ugyanis ez egy maven-es projekt.)
//            (1p)
//
//
//    Tanulmányozd a projektet! Vedd észre, hogy a benne szereplő osztályok különböző package-ekben találhatók! Nézd meg az összes osztályt, interface-t, olvasd el a kommenteket! Fordíts ez után külön figyelmet a Labyrinth és a Player interfacekre, továbbá a Coordinate osztályra, illetve az enumokra, exception-ökre!
//
//
//    Folytasd az elkezdett Labyrinth implementációt! A fájlból beolvasás metódusát már elkezdtük neked,
//    a feladatod ennek a class-nak a befejezése. Miközben a LabyrinthImpl osztályt egy-egy metódusát írod, olvasd el a hozzá
//    tartozó kommentet a Labyrinth interface-ben!
//    Valósítsd meg, hogy a LabyrinthImpl osztály tárolni tudjon egy labirintust! Fejezd be a void loadLabyrinthFile(String
//    fileName) metódust! Feltételezheted, hogy mindig helyes formátumú inputot kapsz (mert mondjuk a validálást egy másik
//    komponens már elvégezte a beolvasás előtt). (2p)
//    Valósítsd meg a
//    void setSize(int width, int height)
//    metódust, amellyel be tudjuk állítani a labirintus méretét! (1p)
//    Valósítsd meg az
//    int getWidth() valamint int getHeight()
//    metódusokat! Ezekkel le tudjuk kérni a labirintus szélességét és magasságát. Ha a labirintust még nem inicializáltuk (fájlból beolvasással), akkor -1 értéket adjanak vissza ezek a metódusok! (1-1p)
//    Valósítsd meg a
//    CellType getCellType(Coordinate c) throws CellException
//    metódust! Ezzel a metódussal tudjuk lekérdezni, hogy az adott koordináta a már betöltött labirintusban milyen típusú cellát tartalmaz. A bal felső cella koordinátája (0, 0). Ügyelj arra, hogy ha nem létező koordinátára hivatkozunk, akkor a metódus kivételt dobjon! (2p)
//    Valósítsd meg a
//    void setCellType(Coordinate c, CellType type) throws CellException
//    metódust! Ezzel egy adott cella típusát tudjuk felülírni. Ezt a metódust csak a tesztek használják, de akár a fájlból való beolvasásnál is használhatod (nem kötelező). Ha a type paraméter START, akkor állítsd át a játékos koodinátáját is az adott mezőre! Ügyelj arra, hogy ha nem létező koordinátára hivatkozunk, akkor a metódus kivételt dobjon! (2p)
//    Valósítsd meg a
//    Coordinate getPlayerPosition()
//    metódust! Ez adja vissza, hogy a játékos éppen hol tartózkodik a pályán. (1p)
//    Valósítsd meg a
//    boolean hasPlayerFinished()
//    metódust! Ez akkor adjon vissza igaz értéket, ha a játékos már elért az END cellába (éppen ott áll). Minden más esetben hamisat adjon vissza. (1p)
//    Valósítsd meg a
//    List<Direction> possibleMoves()
//    metódust! Ez a metódus egy maximum 4 elemű listát ad vissza azokkal az irányokkal, amelyek felé a játékos léphet (nem ütközik falba és nem lép ki a labirintusból). (2p)
//    Valósítsd meg a
//    void movePlayer(Direction direction) throws InvalidMoveException
//    metódust. Ez a metódus mozgatja a játékost a pályán. Ha a játékos érvénytelen mezőre lépne (falba ütközik vagy lelép a pályáról), akkor kivételt dob. (2p)
//
//
//    Nézd meg a LabyrinthTest osztályt! Ez egy JUnit teszt és majdnem kész van. Csak három metódust kell benne helyesen megírnod, ezek:
//    private Labyrinth getLabyrinthImpl()
//    private Player getRandomPlayerImpl()
//    private Player getWallFollowerPlayerImpl()
//    Írd meg most a getLabyrinthImpl() metódust az előbbi feladatban megvalósított Labyrinth implementációd segítségével. A unit teszt segítségével ellenőrizd, hogy a Labyrinth implementációd helyesen működik. Ne várd most, hogy a LabyrinthTest minden tesztesete hibátlan legyen, ahhoz előbb még játékosokat is kell készítened!
//            (A getLabyrinthImpl() metódusodnak csak példányosítania kell egyet a 3-as feladatban elkészített osztályodból!)
//            (1p)
//
//
//    Készíts el egy random játékost, aki véletlenszerűen mozog a pályán (úgy, hogy azért falba ne ütközzön). Ehhez készíts egy új osztályt, és implementáld a Player interface-t!
//    Figyeld meg, hogy a Player implementáció nem tárolja, hogy hol tartózkodik a pályán, ez a Labyrinth felelőssége! A Player csupán a következő lépését adja meg.
//    Ellenőrizd megoldásod a LabyrinthTest
//    private Player getRandomPlayerImpl()
//    metódusának megírásával és a teszt futtatásával!
//            (Csak olyan kicsi labirintussal teszteljük ezt a játékost, ahol egy random walk is általában legfeljebb néhány másodpercen belül kivezet a labirintusból.)
//            (2p)
//
//
//    Bizonyítható, hogy egy labirintusból mindig kijutunk, ha annak van kijárata, és az egyik kezünket (mindegy, hogy jobb vagy bal) a bejáratnál a mellettünk lévő falra rakjuk, és úgy megyünk végig a labirintuson, hogy nem engedjük el a falat – azaz mindig balra vagy jobbra tartunk, ahol elágazáshoz érkeztünk.
//    Valósítsd meg ez alapján a  játékost (készíts egy új osztályt, és implementáld a Player interface-t)! Válaszd ki, hogy a játékosod a bal kezét, vagy a jobb kezét “rakja a falra” (a kettő egyszerre nem fog menni), tehát hogy mindig balra vagy jobbra tart-e egy elágazásnál.
//            (4p)WallFollowerPlayer
//
//
//    Összesen: 23 pont.
//
//    Ha kész vagy, commitold a megoldásodat, és push-old! (Ellenőrizd a webes felületen, hogy a SAJÁT repository-dban látod-e a kommitot!) Ha készen vagy tedd publikussá a repodat, és küldd el a linkjét az teszt@progmatic.hu címre, a levélben a neveddel!
//
//    SZORGALMI
//    Természetesen a labirintusból való kijutásnak a leggyorsabb módja az, ha mindig a megfelelő irányba fordulunk :)
//    A Player osztályaink a nextMove metódus bemeneti paramétereként megkapják a Labyrinth implementációt, amin végig kell járniuk. (Feltételezheted, hogy egy Player példánynak csak egy labirintuson kell keresztülhaladnia.) Az igazán okos játékos az első lépése előtt megtervezi az egész utat, és megjegyzi azt. Minden további lépésénél pedig a már megtervezett út következő lépését hajtja végre.
//    Valósítsd meg ez alapján a ConsciousPlayer játékost (készíts egy új osztályt, és implementáld a Player interface-t)!
//    Tipp a megvalósításhoz: kezdetben kiszámolhatjuk, hogy a cellákhoz legalább hány lépésben tudunk eljutni (tehát ha egy cellához két útvonalon is eljuthatunk, mondjuk 10 és 30 lépéssel, akkor azt mondjuk hogy ez a cella 10 lépéssel elérhető). Tehát legyen a START cella 0 lépéssel elérhető, minden (nem fal) szomszédja 1 lépéssel, azok szomszédai (amely nem a START cella) 2 lépéssel elérhető, stb.
//    Könnyen belátható, hogy ha az END cellához adott ez a szám, akkor a hozzá vezető optimális útvonal megkapható oly módon, hogy az END cellától indulva visszafelé felfűzzük azt az útvonalat, amely azokból a cellákból áll, amelyek pontosan eggyel kevesebb lépéssel érhetőek el, mint ahol éppen állunk.
//            +4p a megvalósításért
//+2p, ha az útkereső algoritmusod O(a*b) időben fut, ahol a és b a labirintus oldalhosszai, és utána O(1) időben ad vissza minden következő lépést
}
