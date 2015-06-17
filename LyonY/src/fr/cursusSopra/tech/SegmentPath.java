package fr.cursusSopra.tech;

public class SegmentPath implements ISegmentPath {
	private ISegmentPath segmentPath = null;
	
	public SegmentPath(ISegmentPath segmentPath) {
		this.segmentPath = segmentPath;
	}

	@Override
	public String getFullPath() {
		return null;
	}

}
