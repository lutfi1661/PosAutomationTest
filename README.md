# PosAutomationTest
Working Folder for project automation test POS project

# Aturan penambahan script test
1. Penambahan feature file
   a. sebelum membuat feature file, buat folder baru sesuai dengan nama fitur tanpa spasi pada path src/test/resources
      - Misalnya nama fitur adalah "Kemitraan Akomodasi", maka nama folder : KemitraanAkomodasi
   b. beri nama feature sesuai dengan nama objective testing
      - Misalnya nama objective testing adalah "Tambah Akomodasi", maka nama feature : TambahAkomodasiFeature
2. Penambahan StepDefinition file
   a. sebelum membuat step definition file, buat package baru sesuai dengan nama fitur tanpa spasi pada path  src/test/java
      - Misalnya nama fitur adalah "Kemitraan Akomodasi", maka nama package : KemitraanAkomodasi
   b. beri nama step definition file sesuai dengan nama objective testing
      - Misalnya nama objective testing adalah "Tambah Akomodasi", maka nama step definition file : TambahAkomodasiFeature
3. Untuk skenario login dan open browser sepertinya cukup dibuat satu skenario dan dibuat penulisan behaviournya sama pada semua pengujian fitur
   - Pastikan penulisan  skenario dan step definitionnya dibuat dalam satu format
   - Oleh karena itu, boleh copas dr feature login yang sudah dibuat oleh teman2nya.
4. Pembuatan script test pada setiap produk dibuat dalam satu project, 
   a. sehingga setiap kali selesai membuat script pastikan sudah pull dan lakukan di push
   b. sepakati penamaan behaviour yang sama sehingga tidak menimbulkan konflik
