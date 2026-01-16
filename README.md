# MappingExample
ModalMapper &amp; Builder&amp; MapStruct Comparison
 
 createUser -> ModalMapper örneği 
    -- Tek satırda kaynaktan hedefe maplenir.
    -- Küçük projelerde/Entitylerde hızlı ilerlemeyi sağlar
    -- Dezavantaj : LOOSE stratejisi ile alan maplerinde yanlış mapleme ihtimali 
    -- Dezavantaj : String -> ENUM gibi tanımlanan alanın runtime alan null olarak maplenmesi 
    -- Dezavantaj : Hesaplamalar için tekrar mapping gerekmesi.


 getTotalBalance ->  Builder örneği 
     
     -- Bazı field ların direkt maplenmemesi ( Password gibi)
     -- Hesaplamalar kolay yapılabilir.
     -- LOOSE/STRICT gibi tahminleri yok 
     -- Dezavantaj : Yeni alan geldiğinde tekrar mapleme yapılması lazım
     -- Dezavantaj : Birden fazla dto lar maplenecekse Kod artacaktır.


     getUserContact -> MapStruct örneği

     -- CompileTime da hataları fark edebilme. 
     -- ignore ile maplenmesi istenilmeyen alanları maplemez
     -- hesaplama yapılabilir
     -- String -> Enum convert edebilir
     -- ModalMapper a göre hızlı 
     -- null olmasını istenilmeyen alanlarda default değer verilebilir.
     -- Mapper Interface ve mapping ler yazıldığından projeye ekstra kod eklenir.
