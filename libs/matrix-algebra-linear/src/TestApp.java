import Linear.Matrices.MatrixOperators;
import Linear.Transforms.*;
import Linear.Vectors.Vector;


public class TestApp {
    public static void main(String[] args) {
        Vector vector2d = new Vector(2, new float[]{1, 2});
        System.out.println("Vetor 2d: " +"\n"+vector2d);

        System.out.println(MatrixOperators.times(1.2f, vector2d));

        Vector resultTranslate2d = Translate.translate2D(vector2d, 5, 6);
        Vector resultRotation2d = Rotation.rotation2D(vector2d, 90);
        Vector resultProjection2dX = Projection.projection2DX(vector2d);
        Vector resultProjection2dY = Projection.projection2DY(vector2d);
        Vector resultReflection2dX = Reflection.reflection2DX(vector2d);
        Vector resultReflection2dY = Reflection.reflection2DY(vector2d);
        Vector resultShearing2d = Shearing.shearing2D(vector2d, 1.5f, 2.5f);

        Vector vector3d = new Vector(3, new float[]{1, 2, 3});
        System.out.println("Vetor 3d: " +"\n"+vector3d);

        Vector resultTranslate3d = Translate.translate3D(vector3d, 5, 6, 7);
        Vector resultRotation3dX = Rotation.rotation3DX(vector3d, 60);
        Vector resultRotation3dY = Rotation.rotation3DY(vector3d, 60);
        Vector resultRotation3dZ = Rotation.rotation3DZ(vector3d, 60);
        Vector resultProjection3dXY = Projection.projection3DXY(vector3d);
        Vector resultProjection3dXZ = Projection.projection3DXZ(vector3d);
        Vector resultProjection3dYZ = Projection.projection3DYZ(vector3d);
        Vector resultReflection3dXY = Reflection.reflection3DXY(vector3d);
        Vector resultReflection3dXZ = Reflection.reflection3DXZ(vector3d);
        Vector resultReflection3dYZ = Reflection.reflection3DYZ(vector3d);


        System.out.println("Translate 2D: " + resultTranslate2d);
        System.out.println("Translate 3D: " + resultTranslate3d);
        System.out.println("Rotation 2D:"+ resultRotation2d);
        System.out.println("Rotation 3DX:"+ resultRotation3dX);
        System.out.println("Rotation 3DY:"+ resultRotation3dY);
        System.out.println("Rotation 3DZ:"+ resultRotation3dZ);
        System.out.println("Projection 2DX:" + resultProjection2dX);
        System.out.println("Projection 2DY:" + resultProjection2dY);
        System.out.println("Projection 3DXY:" + resultProjection3dXY);
        System.out.println("Projection 3DXZ:" + resultProjection3dXZ);
        System.out.println("Projection 3DYZ:" + resultProjection3dYZ);
        System.out.println("Reflection 2DX:" + resultReflection2dX);
        System.out.println("Reflection 2DY:" + resultReflection2dY);
        System.out.println("Reflection 3DXY:" + resultReflection3dXY);
        System.out.println("Reflection 3DXZ:" + resultReflection3dXZ);
        System.out.println("Reflection 3DYZ:" + resultReflection3dYZ);
        System.out.println("Shearing 2D" + resultShearing2d);
    }


}

