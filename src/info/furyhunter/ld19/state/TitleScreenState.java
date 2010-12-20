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
package info.furyhunter.ld19.state;

import info.furyhunter.ld19.DiscoveryGame;
import info.furyhunter.ld19.GameData;
import info.furyhunter.ld19.Images;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class TitleScreenState extends BasicGameState {
	public float textYOffset;
	public float posInc = 0;
	public boolean readyToGo = false;
	
	@Override
	public void keyPressed(int key, char c) {
		if (key == Input.KEY_ENTER) {
			readyToGo = true;
		}
	}
	
	@Override
	public void init(GameContainer container, StateBasedGame game)
			throws SlickException {
		
	}
	
	@Override
	public void enter(GameContainer container, StateBasedGame game)
			throws SlickException {
		readyToGo = false;
		posInc = 0;
		((DiscoveryGame)game).data = new GameData();
	}

	@Override
	public void render(GameContainer container, StateBasedGame game, Graphics g)
			throws SlickException {
		g.drawImage(Images.get("logo"), 0, 0);
		g.setColor(Color.white);
		g.setFont(DiscoveryGame.font);
		g.drawString("Press Enter", 190, 150-textYOffset);
	}

	@Override
	public void update(GameContainer container, StateBasedGame game, int delta)
			throws SlickException {
		textYOffset = (float) (Math.sin(posInc)*16);
		posInc+=0.005*delta;
		
		if (readyToGo) {
			game.enterState(DiscoveryGame.STATE_PLAYFIELD);
		}
	}

	@Override
	public void leave(GameContainer container, StateBasedGame game) {
		this.posInc = 1;
	}
	
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return DiscoveryGame.STATE_TITLESCREEN;
	}

}
