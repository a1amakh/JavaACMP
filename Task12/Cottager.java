/**
 * Cottager class for Task No12
 */

public class Cottager {
	private int[] landingCoords = new int[2]; // Landing coordinates of the cottager
	private int[] plotCoords = new int[8]; // Plot coordinates of the cottager

	public Cottager(int[] landingCoords, int[] plotCoords) { // Construction for Class Cottager
		this.landingCoords = landingCoords;
		this.plotCoords = plotCoords;
	}

	public int[] getLandingCoords() { // Getter for getting landing coords
		return landingCoords;
	}

	public int[] getPlotCoords() { // Getter for getting plot coords
		return plotCoords;
	}
}