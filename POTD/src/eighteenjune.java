public class eighteenjune {


    /// ////Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the hour and the minute hand.
    ///
    /// Answers within 10-5 of the actual value will be accepted as correct

    public double angleClock(int hour, int minutes) {
        //// now we know that minute angle will be = 6 times the min for the hour know
        /// that =

        /// 1 hour == 30 degree and the minuu( 0.5 of minutes )

        double HourAngle = (30.0 * hour) + (0.5 * minutes);
        double minAngle = minutes * 6.0;

        double difference = Math.abs(HourAngle - minAngle);

        return Math.min(difference, 360 - difference);


    }
}
