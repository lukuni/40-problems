## Бодлогын өгүүлбэр (Монгол)

Танд мод (циклгүй энгийн холбогдсон график) өгсөн.
Ойн холбосон бүрэлдэхүүн хэсэг бүр тэгш тооны зангилаа агуулж байхаар ой модыг авахын тулд модноос авч болох хамгийн их ирмэгийг ол.
Жишээ нь, дараах зангилаатай модыг хамгийн их хэмжээгээр огтолж, тэгш ой бий болгож болно.
зураг
Функцийн тодорхойлолт
Доорх засварлагчийн evenForest функцийг гүйцээнэ үү. Энэ нь тайлбарласны дагуу бүхэл тоог буцаах ёстой.
evenForest нь дараах параметртэй:
t_nodes: модны зангилааны тоо
t_edges: модны чиглэлгүй ирмэгүүдийн тоо
t_from: ирмэг бүрийн эхлэлийн зангилаа
t_to: ирмэг тус бүрийн төгсгөлийн зангилаа, (t_from руу индексээр тааруулна.)
Оролтын формат
Оролтын эхний мөрөнд хоёр бүхэл тоо, зангилаа ба ирмэгийн тоог агуулна.
Дараагийн мөрөнд модны ирмэгээр холбогдсон зангилаануудыг зааж өгөх хоёр бүхэл тоо байна. Модны үндэс нь зангилаа юм.
Хязгаарлалт


Тэмдэглэл: Оролтонд байгаа мод нь тэгш тооны зангилаа агуулсан бүрэлдэхүүн хэсгүүдэд хэзээд задарч болохуйц байх болно. эерэг тэгш бүхэл тоонуудын олонлог юм.
Гаралтын формат
Устгасан ирмэгийн тоог хэвлэ.
Жишээ оролт 1
Хуулбар татаж авах
Чиглэлгүй график: t
2
1
3
4
5
6
7
8
9
10


10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8
Жишээ гаралт 1
2
Тайлбар 1
Хүссэн үр дүнд хүрэхийн тулд ирмэгийг арилгана.




## Холбоос

https://www.hackerrank.com/challenges/even-tree/problem?isFullScreen=true





## Нотолгоо, тайлбар

Энд өгөгдсөн модноос (tree) хамгийн их хэдэн ирмэгийг (edge) таслаж авч болохыг олох асуудлыг шийдсэн байгаа. Гол зорилго бол:
 тасалсны дараа үлдсэн бүх холбогдсон бүрэлдэхүүнүүд (components) нь тэгш тооны орой (nodes)-той байхаар таслах.

 Алгоритмын нотолгоо, тайлбар

 Асуудлын гол санаа:

1. Мод гэдэг нь цикльгүй, холбоотой граф тул ямар ч хоёр орой хооронд зөвхөн **нэг зам** байна.
2. Хэрэв **тэгш тооны оройтой дэд мод** олдвол, тухайн дэд модыг үндсэн модноос **нэг ирмэгээр салгаж болно**.
3. Харин тухайн дэд мод тэгш биш бол салгавал үлдсэн нь сондгой болж, нөхцөл хангахгүй.

---

 Алгоритмын ажиллагаа:

1. **DFS (гүнээр хайх)** аргаар үндэснээс (`1-р орой`) эхлэн модыг бүхэлд нь явна.
2. Явах явцдаа:

   * Хүүхэд орой бүрийн дэд модны оройн тоог тооцно.
   * Хэрвээ тухайн дэд мод **тэгш тооны оройтой байвал**, түүнийг салгах боломжтой гэж үзэж **ирмэгийг 1-ээр нэмэгдүүлнэ**.
   * Үгүй бол тухайн оройг эцгийн модонд нэмж тоолно.

---

 Жишээ:

```text
Орж ирсэн мод:
10 9
2 1
3 1
4 3
5 2
6 1
7 2
8 6
9 8
10 8

Бүтэн модны оройн тоо = 10 → тэгш байна
DFS хийж үзвэл:
- 8-р орой дэд мод 3 оройтой → сондгой, таслах боломжгүй
- 2-р орой дэд мод 4 оройтой → таслах боломжтой
- 3-р орой дэд мод 2 оройтой → таслах боломжтой

 Нийт 2 ирмэг тасалж болно.
```

---

 Алгоритмын зөв болох нотолгоо:

* Модонд `n` орой байгаа бол нийт `n-1` ирмэг байна.
* Тэгш тооны оройг салгаж авах болгонд мод хоёр хэсэг болж хуваагдана.
* Гэхдээ аль ч хэсэг **тэгш тоотой** байх нөхцөлийг зөвхөн **дэд модны оройн тоо нь тэгш** байх тохиолдолд л хангаж чадна.
* Тиймээс зөвхөн `DFS`-ээр шалгаж байж салгаж болох ирмэгийг олох нь **зөв бөгөөд бүрэн шийдэл** юм.

---

 Дүгнэлт

| Тайлбар                  | Утга                                          |
| ------------------------ | --------------------------------------------- |
| Орлуулалт ашигласан арга | DFS (гүн давталт)                             |
| Цагийн нийлбэр           | O(N) (оройн тооноос хамаарна)                 |
| Санах ойн нийлбэр        | O(N) (граф хадгалах болон `visited[]` массив) |
| Гаралт                   | Салгаж болох хамгийн олон ирмэгийн тоо        |
