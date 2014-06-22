getting and cleaning data assignment
========================================================

**read in data** 
explore the data from the README.txt, we know that:
- 'features.txt': List of all features.

- 'activity_labels.txt': Links the class labels with their activity name.

- 'train/X_train.txt': Training set.

- 'train/y_train.txt': Training labels.

- 'test/X_test.txt': Test set.

- 'test/y_test.txt': Test labels.

The following files are available for the train and test data. Their descriptions are equivalent. 

'train/subject_train.txt': Each row identifies the subject who performed the activity for each window sample. Its range is from 1 to 30. 

```r
setwd("/Users/craiglab/Downloads/data/UCI HAR Dataset/")
x_test <- read.table("./test/X_test.txt")
dim(x_test)  ###2947 X 561
```

```
## [1] 2947  561
```

```r
head(x_test[, 1:5])
```

```
##       V1       V2       V3      V4      V5
## 1 0.2572 -0.02329 -0.01465 -0.9384 -0.9201
## 2 0.2860 -0.01316 -0.11908 -0.9754 -0.9675
## 3 0.2755 -0.02605 -0.11815 -0.9938 -0.9699
## 4 0.2703 -0.03261 -0.11752 -0.9947 -0.9733
## 5 0.2748 -0.02785 -0.12953 -0.9939 -0.9674
## 6 0.2792 -0.01862 -0.11390 -0.9945 -0.9704
```

```r
y_test <- read.table("./test/y_test.txt")
dim(y_test)  ### 2947 X 1
```

```
## [1] 2947    1
```

```r
## head(y_test)
subject_Test <- read.table("./test/subject_test.txt")
dim(subject_Test)  ### 2947 X 1
```

```
## [1] 2947    1
```

```r
## head(subject_test)
x_train <- read.table("./train/X_train.txt")
dim(x_train)  ### 7352 X 561
```

```
## [1] 7352  561
```

```r
## head(x_train[, 1:5])
y_train <- read.table("./train/y_train.txt")
dim(y_train)  ### 7352 X 1
```

```
## [1] 7352    1
```

```r
### head(y_train)
subject_Train <- read.table("./train/subject_train.txt")
dim(subject_Train)  ### 7352 X 1
```

```
## [1] 7352    1
```

```r
### head(subject_Train)
```


**1. Merges the training and the test sets to create one data set**

x_test, y_test and subject_test has the same nrow, and they can be cbinded togheter. 

```r
Test <- cbind(subject_Test, y_test, x_test)
dim(Test)
```

```
## [1] 2947  563
```

```r
class(Test)
```

```
## [1] "data.frame"
```

x_train, y_train and subject_train has the same nrow, and they can be cbinded togheter. 

```r
Train <- cbind(subject_Train, y_train, x_train)
dim(Train)
```

```
## [1] 7352  563
```

```r
class(Train)
```

```
## [1] "data.frame"
```

then rbind  test and train

```r
activityTotal <- rbind(Test, Train)
dim(activityTotal)  ## 10299 X 563
```

```
## [1] 10299   563
```

```r
class(activityTotal)
```

```
## [1] "data.frame"
```


**Extracts only the measurements on the mean and standard deviation for each measurement.**

since 'features.txt': List of all features.
You can also embed plots, for example:


```r
features <- read.table("/Users/craiglab/Downloads/data/UCI HAR Dataset/features.txt", 
    stringsAsFactor = FALSE)
dim(features)
```

```
## [1] 561   2
```

```r
## head(features)

## features match the actitiy in x_train and y_train and is the colname for
## them.
colnames(activityTotal) <- c("subjects", "labels", features$V2)
## remove the '()' from the colnames
colnames(activityTotal) <- gsub("([-])|[[:punct:]]", "\\1", colnames(activityTotal))
## construct the index for the columns of mean and standard deviation
## measurements.
ind <- grep("mean|std", colnames(activityTotal), ignore.case = TRUE)
length(ind)  ##86 
```

```
## [1] 86
```

```r
### then extract these columnes with first 2 columns for subjects and labels
activityOnlyMeanStd <- activityTotal[, c(1:2, ind)]
dim(activityOnlyMeanStd)  ## 10299 X 88 
```

```
## [1] 10299    88
```



**Uses descriptive activity names to name the activities in the data set**

from the README.txt we know 'activity_labels.txt': Links the class labels with their activity name.
So we read in activity_labels.txt first

```r
activity_labels <- read.table("/Users/craiglab/Downloads/data/UCI HAR Dataset/activity_labels.txt", 
    stringsAsFactor = F)
dim(activity_labels)
```

```
## [1] 6 2
```

```r
activity_labels
```

```
##   V1                 V2
## 1  1            WALKING
## 2  2   WALKING_UPSTAIRS
## 3  3 WALKING_DOWNSTAIRS
## 4  4            SITTING
## 5  5           STANDING
## 6  6             LAYING
```

```r
### write a function to replace lables with descriptive names
replace <- function(x) {
    for (i in 1:nrow(activity_labels)) {
        if (x == activity_labels[i, 1]) {
            x <- activity_labels[i, 2]
        }
    }
    x
}
activityOnlyMeanStd$labels <- sapply(activityOnlyMeanStd$labels, replace)
```


**Appropriately labels the data set with descriptive variable names.**

Since the variables have been labeled and according to features.txt file and removed some punctuations. The step is not needed, but the details of variable names will be explained in codebook.

**Creates a second, independent tidy data set with the average of each variable for each activity and each subject.**


```r
activityMeanStdAverage <- aggregate(activityOnlyMeanStd[, 3:88], by = list(activityOnlyMeanStd$subjects, 
    activityOnlyMeanStd$labels), mean)
colnames(activityMeanStdAverage)[1:2] <- c("subjects", "labels")
activityMeanStdAverage[1:5, 1:5]
```

```
##   subjects labels tBodyAcc-mean-X tBodyAcc-mean-Y tBodyAcc-mean-Z
## 1        1 LAYING          0.2216        -0.04051         -0.1132
## 2        2 LAYING          0.2814        -0.01816         -0.1072
## 3        3 LAYING          0.2755        -0.01896         -0.1013
## 4        4 LAYING          0.2636        -0.01500         -0.1107
## 5        5 LAYING          0.2783        -0.01830         -0.1079
```


save the tidy data file

```r
write.table(activityMeanStdAverage, "/Users/craiglab/gettingandcleaningdata/tidydata.csv", 
    sep = ",", col.names = TRUE)
```





