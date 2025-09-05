package task1

import java.util.LinkedHashMap

fun main() {
    //demoList()
    //demoSet()
    demoMap()
}

fun demoList() {

    //khoi tao list
    val numbers = listOf(1, 2, 3, 4, 5)
    ArrayList<Int>(5)

    numbers.map { it + 1 }.also(::println)

    numbers.filter { it % 2 == 0 }.also(::println)

    numbers.reduce { acc, element -> acc + element }.also(::println)
    numbers.reduceRight { element, acc -> element + acc }.also(::println)

    numbers.reduceIndexed { index, acc, element -> acc + index + element }.also(::println)
    numbers.reduceRightIndexed { index, element, acc -> acc + index + element }.also(::println)

    numbers.reduceIndexedOrNull { index, acc, element -> acc + index + element }
        ?.also(::println)
    numbers.reduceRightIndexedOrNull { index, element, acc -> acc + index + element }
        ?.also(::println)

    numbers.reduceOrNull { acc, element -> acc + element }
        ?.also(::println)
    numbers.reduceRightOrNull { element, acc -> acc + element }
        ?.also(::println)

    numbers.forEach { element ->
        println(element)
    }

    //lay phan tu dau tien
    println(numbers.first())

    //lay phan tu cuoi cung
    println(numbers.last())

    //lay n phan tu dau tien
    println(numbers.take(2))

    //lấy n phần tử cuối cùng
    println(numbers.takeLast(2))

    //lấy n phần tử đầu tiên thỏa mãn điều kiện
    println(numbers.takeWhile { it < 3 })

    //lấy n phần tử cuối cùng thỏa mãn điều kiện
    println(numbers.takeLastWhile { it > 1 })

    //bỏ đi n phần tử đầu tiên
    println(numbers.drop(2))

    //bỏ đi n phần tử cuối cùng
    println(numbers.dropLast(2))

    //bỏ đi n phần tử đầu tiên thỏa mãn điều kiện
    println(numbers.dropWhile { it < 3 })

    //bỏ đi n phần tử cuối cùng thỏa mãn điều kiện
    println(numbers.dropLastWhile { it > 1 })

    //tổng các phần tử
    println(numbers.sum())

    //trung bình cộng các phần tử
    println(numbers.average())

    //đếm số phần tử thỏa mãn điều kiện
    println(numbers.count { it > 2 })

    //kiểm tra tất cả các phần tử có thỏa mãn điều kiện không
    println(numbers.all { it > 0 })

    //kiểm tra có ít nhất một phần tử thỏa mãn điều kiện không
    println(numbers.any { it > 3 })

    //kiểm tra list có rỗng không
    println(numbers.isEmpty())

    //kiểm tra list có chứa phần tử nào đó không
    println(numbers.contains(3))

    //tìm phần tử nhỏ nhất trả về null nếu list rỗng
    println(numbers.minOrNull())

    //tìm phần tử lớn nhất trả về null nếu list rỗng
    println(numbers.maxOrNull())

    //sắp xếp tăng dần
    println(numbers.sorted())

    //sắp xếp giảm dần
    println(numbers.sortedDescending())

    //đảo ngược thứ tự các phần tử
    println(numbers.reversed())

    //tạo một list mới chứa các phần tử duy nhất
    val duplicateNumbers = listOf(1, 2, 2, 3, 3, 3)
    println(duplicateNumbers.distinct())

    //ghép 2 list
    val otherNumbers = listOf(6, 7, 8)
    println(numbers.plus(otherNumbers))

    //lấy phần tử tại vị trí index
    println(numbers.get(2))

    //tìm vị trí đầu tiên của phần tử
    println(numbers.indexOf(3))

    //tìm vị trí cuối cùng của phần tử
    val numbersWithDuplicates = listOf(1, 2, 3, 2, 1)
    println(numbersWithDuplicates.lastIndexOf(2))

    //tạo một sublist
    println(numbers.subList(1, 4))

    //kiểm tra xem hai list có bằng nhau không
    val list1 = listOf(1, 2, 3)
    val list2 = listOf(1, 2, 3)
    val list3 = listOf(3, 2, 1)
    println(list1.equals(list2))
    println(list1.equals(list3))
}

fun demoSet() {

    //khoi tao
    setOf(1, 2, 3, 4, 5)
    mutableSetOf(1, 2, 3, 4, 5)

    val hashSet = HashSet<Int>(5, 0.75f)
    hashSet.add(1)
    hashSet.add(7)
    hashSet.add(3)

    HashSet(listOf(1, 3, 2, 1, 2, 3))
    hashSetOf(1, 2, 3, 1, 2, 3)
    listOf(1, 2, 3).toHashSet()

    //LinkedHashSet duy trì thứ tự thêm vào của phần tử
    LinkedHashSet<String>(5, 0.75f)
    LinkedHashSet(listOf("a", "b", "c", "d", "e", "a"))
}

fun demoMap() {

    //khoi tao
    val map = mapOf(1 to "a", 2 to "b", 3 to "c")
    val mutableMap = mutableMapOf(1 to "a", 2 to "b", 3 to "c")
    println("Immutable map: $map")
    println("Mutable map: $mutableMap")

    // HashMap không đảm bảo thứ tự các phần tử.
    val hashMap = HashMap<Int, String>(5, 0.75f)
    hashMap[3] = "c"
    hashMap[1] = "a"
    hashMap[2] = "b"
    println("HashMap (no guaranteed order): $hashMap")

    // LinkedHashMap với accessOrder = true, duy trì thứ tự truy cập.
    // Phần tử được truy cập gần nhất sẽ được chuyển xuống cuối.
    val linkedHashMap = LinkedHashMap<Int, String>(5, 0.75f, true)
    linkedHashMap[3] = "c"
    linkedHashMap[1] = "a"
    linkedHashMap[2] = "b"
    println("LinkedHashMap (access order) initial: $linkedHashMap")

    // Truy cập phần tử có key là 3
    linkedHashMap[3]
    println("LinkedHashMap after accessing key 3: $linkedHashMap")

    //LinkedHashMap với accessOrder = false, duy trì thứ tự chèn vào của phần tử
    val linkedHashMap2 = LinkedHashMap<Int, String>(5, 0.75f, false)
    linkedHashMap2[3] = "c"
    linkedHashMap2[1] = "a"
    linkedHashMap2[2] = "b"
    println("LinkedHashMap (insertion order): $linkedHashMap2")

    //thay the gia tri cua mot phan tu
    linkedHashMap2.replace(1, "a1")
    println("LinkedHashMap after replace: $linkedHashMap2")

    //them mot phan tu neu key do chua ton tai
    linkedHashMap2.putIfAbsent(4, "d")
    println("LinkedHashMap after putIfAbsent: $linkedHashMap2")

    //truy cap gía trị của một phần tử thay key
    println(linkedHashMap2.getValue(1))

    //kiểm tra key tồn tại trong map
    println(linkedHashMap2.containsKey(1))

    //kiểm tra giá trị tồn tại trong map
    println(linkedHashMap2.containsValue("a"))

    //kiểm tra map rỗng
    println(linkedHashMap2.isEmpty())

    //Thêm một cặp khóa-giá trị mới vào map hoặc cập nhật giá trị nếu khóa đã tồn tại.
    linkedHashMap2.put(10, "o")

    //Thêm tất cả các cặp khóa-giá trị từ một collection khác vào map hiện tại.
    linkedHashMap2.putAll(
        listOf(
            10 to "muoi", 11 to "muoi mot", 12 to "muoi hai", 13 to "muoi ba", 14 to "muoi bon"
        )
    )

    //Lấy giá trị của một khóa, nếu khóa không tồn tại, tính toán một giá trị mới tu lambda và thêm nó vào map.
    linkedHashMap2.getOrPut(
        15,
        { "muoi lam" }
    )

    //xóa đi phần tử có key được chỉ định
    linkedHashMap2.remove(1)

    //Lặp qua các phần tử
    linkedHashMap2.forEach { (key, value) ->
        println("$key. $value")
    }

    //Biến đổi từng cặp khóa-giá trị thành một giá trị mới và trả về một List chứa các giá trị đó.
    linkedHashMap2.map { (key, value) ->
        "$key-$value"
    }

    //Biến đổi tất cả các khóa và trả về một map mới.
    linkedHashMap2.mapKeys { (key, _) ->
        key * 2
    }

    //Biến đổi tất cả các giá trị và trả về một map mới.
    linkedHashMap2.mapValues { (_, value) ->
        value.uppercase()
    }

    //lọc key thỏa mãn điều kiện
    linkedHashMap2.filterKeys {key->
        key==1
    }

    //lọc value thỏa mãn điều kiện
    linkedHashMap2.filterValues { value->
        value=="mot"
    }

    //trả về một set chứa các key trong map
    linkedHashMap2.keys

    //trả về một set chứa các value trong map
    linkedHashMap2.values

    //thêm giá trị mặc định vào map nếu key không tồn tại
    linkedHashMap2.withDefault {
        "default"
    }
}