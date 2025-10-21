package Transformers;
import robocode.*;
//import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Bumblebee - Um robô que se movimenta em círculos e atira com precisão.
 */
	public class Bumblebee extends Robot
	{
	/**
	 * run: Bumblebee's default behavior
		*/
			public void run() {
			
	      	// Cores do robô
	        	setBodyColor(Color.YELLOW);
		        	setGunColor(Color.BLACK);
		        		setRadarColor(Color.YELLOW);
		        			setScanColor(Color.RED);
		        				setBulletColor(Color.ORANGE);

									 // Mantém o radar se movendo independentemente do canhão
				        				setAdjustRadarForGunTurn(true);
				        					setAdjustGunForRobotTurn(true);
	
							   				// Gira o radar indefinidamente
						       					 while (true) {
						           					 setTurnRadarRight(360);
						            					execute();
						
												// Movimentos do Robô
													ahead(100);
														turnGunRight(360);
															back(100);
																turnGunRight(360);

														// Quando detectar um robô inimigo
											           		public void onScannedRobot(ScannedRobotEvent
														   
														        	// Calcular a distância ao inimigo
														           		double distance = e.getDistance();
												 						}

															        	// Girar o canhão para mirar no inimigo
																        	double absoluteBearing = getHeadingRadians() + e.getBearingRadians();
																        		double gunTurn = robocode.util.Utils.normalRelativeAngle(absoluteBearing - getGunHeadingRadians());
																        			setTurnGunRightRadians(gunTurn);
																					}
		
																				// Disparar com potência proporcional à proximidade
																	        		if (getGunHeat() == 0 && Math.abs(getGunTurnRemaining()) < 10) {
																		            	double firePower = Math.min(400 / distance, 3);
																		            		setFire(firePower);
																	        				}

																	    // Movimento lateral para dificultar ser atingido
																	        setTurnRight(e.getBearing() + 90 - 15);
																	        	setAhead(100);
																				}

													  // Movimento lateral para dificultar ser atingido
													        setTurnRight(e.getBearing() + 90 - 15);
													        	setAhead(100);
													    }
		
										   // Quando acertar outro robô com um tiro
										    	public void onBulletHit(BulletHitEvent e) {
										        	setAhead(50);
												 }
			
								    // Quando for atingido por um tiro
								    		public void onHitByBullet(HitByBulletEvent e) {
								        		back(50);
								        			turnRight(30);
								    				}
		
					 // Quando bater na parede
							public void onHitWall(HitWallEvent e) {
								back(50);
									turnRight(90);
							    	}

		// O que fazer ao ser atingido por uma bala
			public void onHitByBullet(HitByBulletEvent {
				// Replace the next line with any behavior you would like
					back(10);
				}
			}
		}
	}	
