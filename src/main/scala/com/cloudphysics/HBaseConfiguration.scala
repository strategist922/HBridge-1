package com.cloudphysics.utilities

import reflect.BeanProperty

object DataType extends Enumeration {
  type DataType = Value
  val dByteSeq, dByte, dInt, dLong, dFloat, dDouble, dString, dBoolean, dTime = Value
}

case class HBaseConfig(hbaseZookeeperQuorum: String,
  hbaseZookeeperClientPort: String,
  hbaseWriteBufferSize: String,
  hbaseMaster: String,
  hbasetable: String,
  hbaseColumFamily: String)

class InventoryConfig {
  @BeanProperty var hbasetable: String = null
  @BeanProperty var hbaseColumFamily: String = null
  @BeanProperty var hbaseZookeeperQuorum: String = null
  @BeanProperty var hbaseZookeeperClientPort: String = null
  @BeanProperty var hbaseWriteBufferSize: String = null
  @BeanProperty var hbaseMaster: String = null

  def getHbaseConfiguration: HBaseConfig = {
    val conf = HBaseConfig(hbaseZookeeperQuorum,
      hbaseZookeeperClientPort,
      hbaseWriteBufferSize,
      hbaseMaster,
      hbasetable, hbaseColumFamily)
    conf
  }

  override def toString: String = {
    return String.format("hbasetable (%s), hbaseconfig (%s)", hbasetable, getHbaseConfiguration)
  }
}