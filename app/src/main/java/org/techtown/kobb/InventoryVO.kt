package org.techtown.kobb

data class InventoryVO(
                        val invent_num : String, // 순번
                       val invent_name: String, // 이름
                       val invent_price: String, // 가격
                       val invent_stock : String, // 잔여수량
                       val invent_partner : String, // 거래처
                       val invent_partNum : String) // 거래처 연락처
