package com.github.balloob.react.sidebar

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.VdomNode
import org.scalajs.dom
import scala.util.Try

import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport

/**
  * Suggest.io
  * User: Konstantin Nikiforov <konstantin.nikiforov@cbca.ru>
  * Created: 08.12.17 11:57
  * Description: react-sidebar scala wrapper.
  */
object Sidebar {

  val component = JsComponent[SidebarProps, Children.Varargs, SidebarState]( js.constructorOf[SidebarForceIosJs] )

  def apply(props: SidebarProps)(children: VdomNode*) = component( props )(children: _*)

}


@JSImport("react-sidebar", JSImport.Default)
@js.native
class SidebarJs(props: SidebarProps) extends js.Object {
  def componentDidMount(): Unit = js.native
  def componentDidUpdate(): Unit = js.native
  def onTouchStart(e: ReactTouchEvent): Unit = js.native
  def onTouchMove(e: ReactTouchEvent): Unit = js.native
  def setState(s: SidebarState): Unit = js.native
  def saveSidebarWidth(): Unit = js.native
  def render(): raw.React.Element = js.native
}


/** Hard rollback for https://github.com/balloob/react-sidebar/commit/01dd3478af3349a409882bdd220ead6b3e3791c5 */
class SidebarForceIosJs(props: SidebarProps) extends SidebarJs(props) {
  override def componentDidMount(): Unit = {
    setState(new SidebarState {
      override val dragSupported = Try(!js.isUndefined(dom.window.asInstanceOf[WindowStub].ontouchstart)) getOrElse false
    })
    saveSidebarWidth()
  }
}


/** State js-object for [[SidebarJs]]. */
trait SidebarState extends js.Object {
  val sidebarWidth: js.UndefOr[Int] = js.undefined
  val touchIdentifier, touchStartX, touchCurrentX: js.UndefOr[js.Any] = js.undefined
  val dragSupported: Boolean
}


@js.native
sealed trait WindowStub extends js.Object {
  var ontouchstart: js.UndefOr[js.Function1[dom.TouchEvent, _]] = js.native
}
