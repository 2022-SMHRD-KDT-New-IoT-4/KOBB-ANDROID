package org.techtown.kobb


data class MenuVO(
    // Control_menu_page 와 연결
    var name: String = "",
    var description: String = "",
    var isExpanded: Boolean = false,
    var image: Int = -1
)