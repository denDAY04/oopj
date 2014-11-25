/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPBeans;

import ModelClasses.RoutePlannerJourney;
import java.util.GregorianCalendar;

/**
 *
 * @author Qesss
 */
public interface RPJInterface {
   RoutePlannerJourney createRouteplannerJourney(int origin, int destination, GregorianCalendar timeDeparture) throws Exception;
}
