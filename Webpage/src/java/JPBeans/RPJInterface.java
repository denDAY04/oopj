/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JPBeans;

import JPBeans.model.RoutePlannerJourney;
import java.util.GregorianCalendar;

/**
 *
 * @author Qesss
 */
public interface RPJInterface {
   RoutePlannerJourney createRouteplannerJourney(String origin, String destination, GregorianCalendar timeDeparture);
}
