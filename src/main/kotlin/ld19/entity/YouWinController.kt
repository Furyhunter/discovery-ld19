/* discovery . Palpable Heroic Perception
 * Copyright (c) 2010, Furyhunter <furyhunter600@gmail.com>
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 *   
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *   
 * * Neither the name of Furyhunter nor the names of his contributors may be
 *   used to endorse or promote products derived from this software without
 *   specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package ld19.entity

import ld19.DiscoveryGame
import ld19.state.PlayfieldState
import org.newdawn.slick.Color
import org.newdawn.slick.GameContainer
import org.newdawn.slick.Graphics
import org.newdawn.slick.SlickException
import org.newdawn.slick.state.transition.EmptyTransition
import org.newdawn.slick.state.transition.FadeOutTransition

class YouWinController : Entity() {
    var life = 5f
    @Throws(SlickException::class)
    override fun update(container: GameContainer, state: PlayfieldState,
                        game: DiscoveryGame, delta: Int) {
        life -= (0.001 * delta).toFloat()
        if (life <= 0) {
            game.enterState(DiscoveryGame.STATE_GAMEOVER,
                    FadeOutTransition(Color.white, 5000),
                    EmptyTransition())
        }
    }

    @Throws(SlickException::class)
    override fun render(container: GameContainer, state: PlayfieldState,
                        game: DiscoveryGame, graphics: Graphics) {
        // TODO Auto-generated method stub

    }

    override fun keyPressed(key: Int, c: Char) {
        // TODO Auto-generated method stub

    }

    override fun keyReleased(key: Int, c: Char) {
        // TODO Auto-generated method stub

    }

    override // TODO Auto-generated method stub
    val type: String
        get() = "Entity.YouWinController"

    override fun create(state: PlayfieldState) {
        // TODO Auto-generated method stub

    }

    override fun destroy(state: PlayfieldState) {
        // TODO Auto-generated method stub

    }

}
