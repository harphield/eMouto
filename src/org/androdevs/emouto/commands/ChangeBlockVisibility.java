package org.androdevs.emouto.commands;

import org.androdevs.emouto.gui.layout.Block;

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
