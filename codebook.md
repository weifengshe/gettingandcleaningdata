Codebook for Human Activity Recognition Using Smartphones Dataset
========================================================
the dataset came from 
Jorge L. Reyes-Ortiz, Davide Anguita, Alessandro Ghio, Luca Oneto.
Smartlab - Non Linear Complex Systems Laboratory
DITEN - Universit‡ degli Studi di Genova.
Via Opera Pia 11A, I-16145, Genoa, Italy.
activityrecognition@smartlab.ws
www.smartlab.ws

The experiments have been carried out with a group of 30 volunteers within an age bracket of 19-48 years. Each person performed six activities (WALKING, WALKING_UPSTAIRS, WALKING_DOWNSTAIRS, SITTING, STANDING, LAYING) wearing a smartphone (Samsung Galaxy S II) on the waist. Using its embedded accelerometer and gyroscope, The authers captured 3-axial linear acceleration and 3-axial angular velocity at a constant rate of 50Hz. The experiments have been video-recorded to label the data manually. The obtained dataset has been randomly partitioned into two sets, where 70% of the volunteers was selected for generating the training data and 30% the test data. 

The sensor signals (accelerometer and gyroscope) were pre-processed by applying noise filters and then sampled in fixed-width sliding windows of 2.56 sec and 50% overlap (128 readings/window). The sensor acceleration signal, which has gravitational and body motion components, was separated using a Butterworth low-pass filter into body acceleration and gravity. The gravitational force is assumed to have only low frequency components, therefore a filter with 0.3 Hz cutoff frequency was used. From each window, a vector of features was obtained by calculating variables from the time and frequency domain. See 'features_info.txt' for more details. 

the following steps has been taken to analyze the data.

1. merge the train and test data set together. 
   * x_train, y_train and subject_train are merged to Train
   * x_test, y_test and subject_test are merged to Test
   * Train and Test are merged to activityTotal
   
2. Extract the mean and standard deviation measurement
   * read in the features.txt file which represents each measurement for x_test and x_train
   * use the file to label the colnames of activityTotal
   * remove the punctuation from colnames
   * extract only the colnames with mean and std variables
   
3. Uses descriptive activity names to name the activities in the data set
   * read in activities_labels.txt file which has the activities with repect to the number
   * then change the number ot discriptive activities according to this file. 
   
4. Appropriately labels the data set with descriptive variable names.
   this step has been done together with step 2.
   and the details of each variable are explained below.
   
5. Creates a second, independent tidy data set with the average of each variable for each activity and each subject.
   * use aggregate function to calculate the mean for each activity and each subject
   * with the new data frame to a file: tidydata.csv
 
 
the details for each variable name:

't' denotes time, the time domain signals were captured at a constant rate of 50 Hz. 

'f' donotes a fast fourier transform (FFT) was applied.

'Acc-XYZ' denotes accelerometer 3-axial signal.

'Gyro-XYX' denotes gyroscope 3-axial raw signal.

'-XYZ' is used to denote 3-axial signals in the X, Y and Z directions.
