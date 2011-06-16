package org.androdevs.emouto.commands;

import org.androdevs.emouto.gui.layout.Block;

/**
 * Showing and hiding UI blocks.
 * Perpetual means it will be hidden when it's visible and shown when it's hidden.
 * @author harph
 *
 */
public class ChangeBlockVisibility implements ICommand 
{
	private Block block;
	private boolean visible;
	private boolean perpetual = false;
	
	public ChangeBlockVisibility(Block b)
	{
		block = b;
		perpetual = true;
	}
	
	public ChangeBlockVisibility(Block b, boolean visible)
	{
		block = b;
		this.visible = visible;
	}
	
	@Override
	public void execute(Object data) 
	{
		if (perpetual)
		{
			if (block.isVisible())
				block.hide();
			else block.show();
		}
		else if (visible)
			block.show();
		else block.hide();
	}

}
