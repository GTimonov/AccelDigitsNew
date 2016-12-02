package com.mygdx.game.utils;

import com.badlogic.gdx.input.GestureDetector;

/**
 Created by Goshan on 18.11.2016.
 <p>
  F — переменная описывающая динамику системы, в случае с топливом — это может быть коэффициент
 определяющий расход топлива на холостых оборотах за время дискретизации (время между шагами
 алгоритма).  Однако помимо расхода топлива, существуют ещё и заправки… поэтому для простоты
 примем эту переменную  равную 1 (то есть мы указываем, что предсказываемое значение
 будет равно предыдущему состоянию).
 <p>
 B — переменная определяющая применение управляющего воздействия. Если бы у нас были дополнительная
 информация об оборотах двигателя или степени нажатия на педаль акселератора, то этот параметр бы
 определял как изменится расход топлива за время дискретизации. Так как управляющих воздействий в
 нашей модели нет (нет информации о них), то принимаем B = 0.
 <p>
 H — матрица определяющая отношение между измерениями и состоянием системы, пока без объяснений
 примем эту переменную также равную 1.
 <p>
 Определение сглаживающих свойств
 <p>
 R — ошибка измерения может быть определена испытанием измерительных приборов и определением
 погрешности их измерения.
 <p>
 Q — определение шума процесса является более сложной задачей, так как требуется определить
 дисперсию процесса, что не всегда возможно. В любом случае, можно подобрать этот параметр для
 обеспечения требуемого уровня фильтрации.

 */

public class KalmanFilter {

    public float F;  // factor of real value to previous real value
    public float Q; // measurement noise
    public float H;  // factor of measured value to real value
    public float R; // environment noise

    public float state;
    public float covariance;

    public KalmanFilter(float q, float r, float f , float h)
    {
        Q = q;
        R = r;
        F = f;
        H = h;
    }

    public void setState(float state, float covariance) {
        this.state = state;
        this.covariance = covariance;
    }

    public void correct(float data) {
        //time update - prediction
        float X0 = F * state;
        float P0 = F * covariance * F + Q;

        //measurement update - correction
        float K = H * P0 / (H * P0 * H + R);
        state = X0 + K * (data - H * X0);
        covariance = (1 - K * H) * P0;
    }


}
