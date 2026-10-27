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
    (4,'Regula Falsi I','Polynomial Roots','Hard','Given the Polynomial, and the problem space from a to b below, approximate one of it''s ' ||
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
