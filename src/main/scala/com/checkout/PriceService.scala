package com.checkout

trait PriceService {

  protected def costOfItem(item: String): Int = item match {
    case "Apple" => 60
    case "Orange" => 25
    case other => throw new IllegalArgumentException(s"Item not recognized: $other")
  }
}
