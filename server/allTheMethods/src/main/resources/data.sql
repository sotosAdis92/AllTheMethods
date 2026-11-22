/*
INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
(3,'Regula Falsi I','Polynomial Roots','Hard','Given the Polynomial, and the problem space from a to b below, approximate one of it''s ' ||
                                              'roots, 7 times, using the Regula Falsi Method for each iteration. For ' ||
                                              'Each Iteration below, there is a text field, with the corresponding ' ||
                                              'final result of the method at each iteration, you may write the final ' ||
                                              'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                              'that using the method ' ||
                                              'only one outcome of the' ||
                                              ' polynomial is possible,' ||
                                              ' and you may assume that ' ||
                                              'the problem converages.',
 15,
 'x^3 + 4x^2 - 10',
 'Regula Falsi',
 'x^3 + 4x^2 - 10',
 '{"iterations": 7, "problemSpaceA": 1, "problemSpaceB": 2}');

INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
    (4,'Newton-Raphson I','Polynomial Roots','Hard','Given the Polynomial, and the problem space from a to b below, approximate one of it''s ' ||
                                                  'roots, 7 times, using the Newton-Raphson Method for each iteration. For ' ||
                                                  'Each Iteration below, there is a text field, with the corresponding ' ||
                                                  'final result of the method at each iteration, you may write the final ' ||
                                                  'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                                  'that using the method ' ||
                                                  'only one outcome of the' ||
                                                  ' polynomial is possible,' ||
                                                  ' and you may assume that ' ||
                                                  'the problem converages.',
     15,
     'x^3 + 2x - 5',
     'Newton-Raphson',
     'x^3 + 2x - 5',
     '{"iterations": 7, "xZero": 2}');


INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
    (5,'Newton-Raphson II','Polynomial Roots','Med.','Given the Polynomial, and the problem space from a to b below, approximate one of it''s ' ||
                                                    'roots, 5 times, using the Newton-Raphson Method for each iteration. For ' ||
                                                    'Each Iteration below, there is a text field, with the corresponding ' ||
                                                    'final result of the method at each iteration, you may write the final ' ||
                                                    'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                                    'that using the method ' ||
                                                    'only one outcome of the' ||
                                                    ' polynomial is possible,' ||
                                                    ' and you may assume that ' ||
                                                    'the problem converages.',
     10,
     'x^3 + 4x^2 - 10',
     'Newton-Raphson',
     'x^3 + 4x^2 - 10',
     '{"iterations": 5, "xZero": 2}');

INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
    (6,'Trapezoidal I','Integrals','Med.','Given the Integral, function, and the problem space from a to b below, approximate one of it''s ' ||
                                                     'solution, using the Trapezoidal Rule Method. For ' ||
                                                     'Each blank space below, there is a text field, with the corresponding ' ||
                                                     'final result of the method at each step, you may write the final ' ||
                                                     'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                                     'that using the method ' ||
                                                     'only one outcome of the' ||
                                                     ' polynomial is possible,' ||
                                                     ' and you may assume that ' ||
                                                     'the problem converages.',
     10,
     'x^2 - 2',
     'Trapezoidal Rule',
     'x^2 - 2',
     '{"integrationSpaceA": 1, "integrationSpaceB": 6, "hParameter": 1}');

 */

INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
    (7,'Circles I','Linear Systems','Med.','Given the following matrix, approximate its eigenvalues ' ||
                                          'using the Gerschgorin Circles Method. For ' ||
                                          'Each blank space below, there is a text field, with the corresponding ' ||
                                          'final result of the method at each step, you may write the final ' ||
                                          'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                          'that using the method ' ||
                                          'only one outcome of the' ||
                                          ' polynomial is possible,' ||
                                          ' and you may assume that ' ||
                                          'the problem converages.',
     10,
     '\begin{bmatrix}1 & 2 & 3 \\4 & 5 & 6 \\7 & 8 & 9 \\\end{bmatrix}',
     'Gerschgorin Circles',
     '[1,2,3],[4,5,6],[7,8,9]',
     '{}');


INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
    (8,'Circles II','Linear Systems','Med.','Given the following matrix, approximate its eigenvalues ' ||
                                           'using the Gerschgorin Circles Method. For ' ||
                                           'Each blank space below, there is a text field, with the corresponding ' ||
                                           'final result of the method at each step, you may write the final ' ||
                                           'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                           'that using the method ' ||
                                           'only one outcome of the' ||
                                           ' polynomial is possible,' ||
                                           ' and you may assume that ' ||
                                           'the problem converages.',
     10,
     '\begin{bmatrix}9 & 2 & 1 \\-2 & 5 & 2 \\1 & 1 & 4 \\\end{bmatrix}',
     'Gerschgorin Circles',
     '[9,2,1],[-2,5,2],[1,1,4]',
     '{}');

INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
    (9,'Simpson I','Integrals','Med.','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                            'using the Simpson Integration Method. For ' ||
                                            'Each blank space below, there is a text field, with the corresponding ' ||
                                            'final result of the method at each step, you may write the final ' ||
                                            'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                            'that using the method ' ||
                                            'only one outcome of the' ||
                                            ' polynomial is possible,' ||
                                            ' and you may assume that ' ||
                                            'the problem converages.',
     10,
     '\int_{1}^{6}x^2-2',
     'Simpson',
     'x^2 - 2',
     '{"integrationSpaceA": 1, "integrationSpaceB": 6, "hParameter": 1}');


INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
    (9,'Simpson I','Integrals','Med.','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                      'using the Simpson Integration Method. For ' ||
                                      'Each blank space below, there is a text field, with the corresponding ' ||
                                      'final result of the method at each step, you may write the final ' ||
                                      'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                      'that using the method ' ||
                                      'only one outcome of the' ||
                                      ' polynomial is possible,' ||
                                      ' and you may assume that ' ||
                                      'the problem converages.',
     10,
     '\int_{1}^{6}x^2-2',
     'Simpson',
     'x^2 - 2',
     '{"integrationSpaceA": 1, "integrationSpaceB": 6, "hParameter": 1}');

INSERT INTO problem(number,title,category,difficulty,description,points,problem_string,problem_type,function_string,problem_parameters)
VALUES
    (11,'Simpson III','Integrals','Med.','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                         'using the Simpson Integration Method. For ' ||
                                         'Each blank space below, there is a text field, with the corresponding ' ||
                                         'final result of the method at each step, you may write the final ' ||
                                         'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                         'that using the method ' ||
                                         'only one outcome of the' ||
                                         ' polynomial is possible,' ||
                                         ' and you may assume that ' ||
                                         'the problem converages.',
     10,
     '\int_{0}^{2}3x^2+2x',
     'Simpson',
     '3x^2 + 2x',
     '{"integrationSpaceA": 0, "integrationSpaceB": 2, "hParameter": 0.5}'),

    (12,'Simpson IV','Integrals','Hard','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                        'using the Simpson Integration Method. For ' ||
                                        'Each blank space below, there is a text field, with the corresponding ' ||
                                        'final result of the method at each step, you may write the final ' ||
                                        'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                        'that using the method ' ||
                                        'only one outcome of the' ||
                                        ' polynomial is possible,' ||
                                        ' and you may assume that ' ||
                                        'the problem converages.',
     15,
     '\int_{1}^{3}x^4-2x^2+1',
     'Simpson',
     'x^4 - 2x^2 + 1',
     '{"integrationSpaceA": 1, "integrationSpaceB": 3, "hParameter": 0.5}'),

    (13,'Simpson V','Integrals','Med.','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                       'using the Simpson Integration Method. For ' ||
                                       'Each blank space below, there is a text field, with the corresponding ' ||
                                       'final result of the method at each step, you may write the final ' ||
                                       'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                       'that using the method ' ||
                                       'only one outcome of the' ||
                                       ' polynomial is possible,' ||
                                       ' and you may assume that ' ||
                                       'the problem converages.',
     10,
     '\int_{2}^{8}x^2+3x-1',
     'Simpson',
     'x^2 + 3x - 1',
     '{"integrationSpaceA": 2, "integrationSpaceB": 8, "hParameter": 1}'),

    (14,'Simpson VI','Integrals','Hard','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                        'using the Simpson Integration Method. For ' ||
                                        'Each blank space below, there is a text field, with the corresponding ' ||
                                        'final result of the method at each step, you may write the final ' ||
                                        'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                        'that using the method ' ||
                                        'only one outcome of the' ||
                                        ' polynomial is possible,' ||
                                        ' and you may assume that ' ||
                                        'the problem converages.',
     15,
     '\int_{0}^{3}2x^3-x+4',
     'Simpson',
     '2x^3 - x + 4',
     '{"integrationSpaceA": 0, "integrationSpaceB": 3, "hParameter": 0.5}'),

    (15,'Simpson VII','Integrals','Easy','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                         'using the Simpson Integration Method. For ' ||
                                         'Each blank space below, there is a text field, with the corresponding ' ||
                                         'final result of the method at each step, you may write the final ' ||
                                         'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                         'that using the method ' ||
                                         'only one outcome of the' ||
                                         ' polynomial is possible,' ||
                                         ' and you may assume that ' ||
                                         'the problem converages.',
     5,
     '\int_{0}^{2}x^2',
     'Simpson',
     'x^2',
     '{"integrationSpaceA": 0, "integrationSpaceB": 2, "hParameter": 1}'),

    (16,'Simpson VIII','Integrals','Med.','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                          'using the Simpson Integration Method. For ' ||
                                          'Each blank space below, there is a text field, with the corresponding ' ||
                                          'final result of the method at each step, you may write the final ' ||
                                          'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                          'that using the method ' ||
                                          'only one outcome of the' ||
                                          ' polynomial is possible,' ||
                                          ' and you may assume that ' ||
                                          'the problem converages.',
     10,
     '\int_{1}^{5}4x^2-3x+2',
     'Simpson',
     '4x^2 - 3x + 2',
     '{"integrationSpaceA": 1, "integrationSpaceB": 5, "hParameter": 1}'),

    (17,'Simpson IX','Integrals','Hard','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                        'using the Simpson Integration Method. For ' ||
                                        'Each blank space below, there is a text field, with the corresponding ' ||
                                        'final result of the method at each step, you may write the final ' ||
                                        'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                        'that using the method ' ||
                                        'only one outcome of the' ||
                                        ' polynomial is possible,' ||
                                        ' and you may assume that ' ||
                                        'the problem converages.',
     15,
     '\int_{0}^{4}x^3+2x^2-x',
     'Simpson',
     'x^3 + 2x^2 - x',
     '{"integrationSpaceA": 0, "integrationSpaceB": 4, "hParameter": 0.5}'),

    (18,'Simpson X','Integrals','Easy','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                       'using the Simpson Integration Method. For ' ||
                                       'Each blank space below, there is a text field, with the corresponding ' ||
                                       'final result of the method at each step, you may write the final ' ||
                                       'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                       'that using the method ' ||
                                       'only one outcome of the' ||
                                       ' polynomial is possible,' ||
                                       ' and you may assume that ' ||
                                       'the problem converages.',
     5,
     '\int_{0}^{2}3x',
     'Simpson',
     '3x',
     '{"integrationSpaceA": 0, "integrationSpaceB": 2, "hParameter": 1}'),

    (19,'Simpson XI','Integrals','Med.','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                        'using the Simpson Integration Method. For ' ||
                                        'Each blank space below, there is a text field, with the corresponding ' ||
                                        'final result of the method at each step, you may write the final ' ||
                                        'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                        'that using the method ' ||
                                        'only one outcome of the' ||
                                        ' polynomial is possible,' ||
                                        ' and you may assume that ' ||
                                        'the problem converages.',
     10,
     '\int_{1}^{5}x^3-1',
     'Simpson',
     'x^3 - 1',
     '{"integrationSpaceA": 1, "integrationSpaceB": 5, "hParameter": 1}'),

    (20,'Simpson XII','Integrals','Hard','Given the following function, and integration spaces from A to B, approximate its solution ' ||
                                         'using the Simpson Integration Method. For ' ||
                                         'Each blank space below, there is a text field, with the corresponding ' ||
                                         'final result of the method at each step, you may write the final ' ||
                                         'result in there, rounded to the nearest 3rd decimal point. You may assume ' ||
                                         'that using the method ' ||
                                         'only one outcome of the' ||
                                         ' polynomial is possible,' ||
                                         ' and you may assume that ' ||
                                         'the problem converages.',
     15,
     '\int_{0}^{6}x^2-3x+5',
     'Simpson',
     'x^2 - 3x + 5',
     '{"integrationSpaceA": 0, "integrationSpaceB": 6, "hParameter": 0.5}');
