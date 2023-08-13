# BitcoinApplication

USED
- MVVM architectural
- Data Binding , Compose , 
- dependency injection : koin
- Local Database : Realm
- RecyclerView
- Multi Module
- Unit Test
- Call API using : Retrofit
- 


<div style="display:flex;">
  
<img alt="App image" src="/graphics/screenshot_fibonacci.png" width="20%">
<img alt="App image" src="/graphics/screenshot_fibonacci_input.png" width="20%">
<img alt="App image" src="/graphics/screenshot_fibonacci_result.png" width="20%">
<img alt="App image" src="/graphics/screenshot_main.png" width="20%">
<img alt="App image" src="/graphics/screenshot_main_detail_and_converter.png" width="20%">

<img alt="App image" src="/graphics/screenshot_main_detail_and_converter_input.png" width="20%">
<img alt="App image" src="/graphics/screenshot_main_dialog_confirmation.png" width="20%">
<img alt="App image" src="/graphics/screenshot_main_dialog_other.png" width="20%">
<img alt="App image" src="/graphics/screenshot_main_swipe_to_delete.png" width="20%">
<img alt="App image" src="/graphics/screenshot_pincode.png" width="20%">

<img alt="App image" src="/graphics/screenshot_pincode_input.png" width="20%">
  <img alt="App image" src="/graphics/screenshot_prime_number.png" width="20%">
<img alt="App image" src="/graphics/screenshot_prime_number_result.png" width="20%">
</div>
![screenshot_fibonacci](https://github.com/nutchanokp/BitcoinApplication/assets/67836531/d492957c-7c0d-45aa-86d8-7d5e5c70d4bb)


โจทย์
สร้าง Application โดยที่มีฟีเจอร์ดังนี้
แสดงผล currency ของ BTC ของทั้ง 3 ราคา (USD, GBP และ EUR) จาก API
เรทราคา จะต้องมีการ auto update ทุก ๆ 1 นาที
สามารถดูราคาย้อนหลังได้ (โดยจะต้องบันทึกข้อมูลจากข้อ a.)
มี Input field ให้เลือก currency 3 แบบตามข้อ a. จากนั้น สามารถกรอกจำนวนของ currency นั้น ๆ เพื่อแปลงค่าเป็น BTC ได้

โบนัส
เขียน Unit test
เขียน program generate ตัวเลข Fibonacci 
เขียน program generate จำนวนเฉพาะ 
เขียนโค้ดในการ filter array จาก array ของตัวเลข 2 ชุด โดยให้สมาชิกของ array ชุดแรก เหลือเพียงแค่สมาชิกที่มีอยู่ใน array ชุดที่สองเท่านั้น โดยห้ามใช้ function ที่มีอยู่ เช่น map, filter, contain, etc. 


เขียนฟังก์ชัน validate pincode


<a href='/fibonacci/src/main/java\com/nut/cdev/fibonacci/ext/FibonacciExt.kt'>Code Link</a>



