
package SpecFlow.example

import chisel3._
import chisel3.util._


abstract class Stage(val width: Int, val latency: Int = 1) extends Module {
  
  val io = IO(new Bundle {
    val in  = Flipped(Decoupled(UInt(width.W))) 
    val out = Decoupled(UInt(width.W))          
  })

  // for backpressure
  val queue = Module(new Queue(UInt(width.W), entries = latency))
  
  queue.io.enq <> io.in
  protected val logicIn = queue.io.deq
  
  // single cycle stages
  io.out.valid := logicIn.valid
  logicIn.ready := io.out.ready
  
  def detailImpl(): Unit

  detailImpl()



  ///////////////////// downstream propagation of hints 
  def sec (description: String): Unit = {
    println(s"[hint assertions - ${this.name}] $description")
  }

}