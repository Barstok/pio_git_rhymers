package edu.kis.vh.nursery.factory;

import edu.kis.vh.nursery.DefaultCountingOutRhymer;

	// TODO: wszystkie elementy interfejsu sa z definicji publiczne, wiec modyfikatory public sa niepotrzebne
	public interface RhymersFactory {
	
		public DefaultCountingOutRhymer getStandardRhymer();
		
		public DefaultCountingOutRhymer getFalseRhymer();
		
		public DefaultCountingOutRhymer getFIFORhymer();
		
		public DefaultCountingOutRhymer getHanoiRhymer();
		
	}
