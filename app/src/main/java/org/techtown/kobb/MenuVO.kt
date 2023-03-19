package org.techtown.kobb


data class MenuVO(

    val menu_num : Long, // 순번
    val menu_name: String, // 이름
    val menu_price: Long, // 가격
    val menu_sort : String, // 카테고리
    val menu_status : Long, // 메뉴 상태 (판매/품절)
    val menu_image : Double) // 메뉴 이미지



//val menu_num : String, // 순번
//val menu_name: String, // 이름
//val menu_price: String, // 가격
//val menu_sort : String, // 카테고리
//val menu_status : String, // 메뉴 상태 (판매/품절)
//val menu_image : String   // 메뉴 이미지
